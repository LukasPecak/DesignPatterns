package org.lukas.javach.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleControlPanel implements ControlPanel {

    private static Logger log = LoggerFactory.getLogger(SimpleControlPanel.class);

    private int controllerSlotCapacity;
    private Command[] onCommands;
    private Command[] offCommands;
    private Command previousCommand;

    SimpleControlPanel(int controllerSlotCapacity) {
        if (0 > controllerSlotCapacity && controllerSlotCapacity < Integer.MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Cannot create a control panel with %d slot capacity", controllerSlotCapacity));
        }
        this.controllerSlotCapacity = controllerSlotCapacity;
        onCommands = new Command[controllerSlotCapacity];
        offCommands = new Command[controllerSlotCapacity];
        for (int i = 0; i < controllerSlotCapacity; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
        previousCommand = new NoCommand();
    }

    @Override
    public void setDeviceSlot(int numberOfSlot, Command onCommand, Command offCommand) {
        ensureSlotInRange(numberOfSlot);
        Command checkedOnCommand = ensureCommandNotNull(onCommand);
        Command checkedOffCommand = ensureCommandNotNull(offCommand);
        onCommands[numberOfSlot] = checkedOnCommand;
        offCommands[numberOfSlot] = checkedOffCommand;
    }

    private Command ensureCommandNotNull(Command command) {
        Command checkedCommand = new NoCommand();
        if (command != null) {
            checkedCommand = command;
        }
        return checkedCommand;
    }

    @Override
    public void removeDeviceSlot(int numberOfSlot) {
        ensureSlotInRange(numberOfSlot);
        onCommands[numberOfSlot] = new NoCommand();
        offCommands[numberOfSlot] = new NoCommand();
    }

    private void ensureSlotInRange(int numberOfSlot) {
        if (0 > numberOfSlot || numberOfSlot >= controllerSlotCapacity) {
            throw new IllegalArgumentException("Slot out of range");
        }
    }

    @Override
    public void panelPressOnSlot(int slotNumber) {
        ensureSlotInRange(slotNumber);
        onCommands[slotNumber].execute();
        previousCommand = onCommands[slotNumber];
    }

    @Override
    public void panelPressOffSlot(int slotNumber) {
        ensureSlotInRange(slotNumber);
        offCommands[slotNumber].execute();
        previousCommand = offCommands[slotNumber];
    }

    @Override
    public void undoCommand() {
        previousCommand.undo();
    }

    @Override
    public void printPanel() {
        log.info("---------- CONTROL PANEL ----------");
        for (int i = 0; i < controllerSlotCapacity; i++) {
            if (log.isInfoEnabled()) {
                log.info(String.format("| %s |\t| %s |", onCommands[i].getClass().getSimpleName(), offCommands[i].getClass().getSimpleName()));
            }
        }
    }
}

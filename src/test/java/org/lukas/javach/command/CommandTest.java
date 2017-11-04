package org.lukas.javach.command;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class CommandTest {

    private static Logger log = LoggerFactory.getLogger(Command.class);
    private ControlPanel panel;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        panel = new SimpleControlPanel(3);
    }

    @Test
    public void testSetupPanel() {
        log.info("Test panel setup ...");
        panel.printPanel();
    }

    @Test
    public void testNoCommandThrowsUnsupportedOperationException() {
        log.info("Check if NoCommand throws unsupported operation exception");
        thrown.expect(UnsupportedOperationException.class);
        panel.panelPressOnSlot(1);
    }

    @Test
    public void testAddFunctionToSlot() {
        log.info("Test adding function to slot");
        VentilationDriver ventilationDriver = new VentilationDriver();
        int numberOfSlot = 1;
        panel.setDeviceSlot(numberOfSlot, new VentilationOnCommand(ventilationDriver), new VentilationOffCommand(ventilationDriver));
        panel.printPanel();
        panel.panelPressOnSlot(numberOfSlot);
        panel.panelPressOffSlot(numberOfSlot);
    }

    @Test
    public void checkSlotOutOfRange() {
        log.info("Check slot out of range throws exception ...");
        thrown.expect(IllegalArgumentException.class);
        panel.setDeviceSlot(3, new NoCommand(), new NoCommand());
        thrown.expect(IllegalArgumentException.class);
        panel.setDeviceSlot(-1, new NoCommand(), new NoCommand());
    }

    @Test
    public void checkRemoveCommandsFromSlot() {
        log.info("Check remove commands from slot ...");
        KitchenLightDriver kitchenLightDriver = new KitchenLightDriver();
        int slotNumber = 0;
        panel.setDeviceSlot(slotNumber, new KitchenLightOnCommand(kitchenLightDriver), new KitchenLightOffCommand(kitchenLightDriver));
        panel.printPanel();
        panel.removeDeviceSlot(slotNumber);
        panel.printPanel();
        thrown.expect(UnsupportedOperationException.class);
        panel.panelPressOffSlot(slotNumber);
        panel.removeDeviceSlot(1);
    }

    @Test
    public void checkUndoCommand() {
        log.info("Check undo command");
        KitchenLightDriver kitchenLightDriver = new KitchenLightDriver();
        int numberOfSlot = 0;
        panel.setDeviceSlot(numberOfSlot, new KitchenLightOnCommand(kitchenLightDriver), new KitchenLightOffCommand(kitchenLightDriver));
        panel.printPanel();
        panel.panelPressOnSlot(numberOfSlot);
        panel.undoCommand();
        log.info("Undo one more time ...");
        panel.panelPressOffSlot(numberOfSlot);
        panel.undoCommand();
    }

    @Test
    public void checkMacroCommands() {
        CommandMacro macro = new CommandMacro(new KitchenLightOnCommand(new KitchenLightDriver()), new VentilationOffCommand(new VentilationDriver()));
        int slotNumber = 0;
        panel.setDeviceSlot(slotNumber, macro, new NoCommand());
        panel.printPanel();
        panel.panelPressOnSlot(slotNumber);
        panel.undoCommand();
    }
}
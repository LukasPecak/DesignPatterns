package org.lukas.javach.command;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public interface ControlPanel {

    void setDeviceSlot(int numberOfSlot, Command onCommand, Command offCommand);

    void removeDeviceSlot(int numberOfSlot);

    void panelPressOnSlot(int slotNumber);

    void panelPressOffSlot(int slotNumber);

    void undoCommand();

    void printPanel();
}

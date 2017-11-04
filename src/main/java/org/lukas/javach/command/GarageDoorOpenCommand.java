package org.lukas.javach.command;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class GarageDoorOpenCommand implements Command {

    private GarageDoorDriver garageDoorDriver;

    public GarageDoorOpenCommand(GarageDoorDriver garageDoorDriver) {
        if (garageDoorDriver == null) {
            throw new IllegalArgumentException("Cannot create a command for null argument");
        }
        this.garageDoorDriver = garageDoorDriver;
    }

    @Override
    public void execute() {
        garageDoorDriver.openGarageDoor();
    }

    @Override
    public void undo() {
        garageDoorDriver.closeGarageDoor();
    }
}

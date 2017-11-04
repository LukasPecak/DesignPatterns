package org.lukas.javach.command;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class VentilationOffCommand implements Command {

    private VentilationDriver ventilationDriver;

    VentilationOffCommand(VentilationDriver ventilationDriver) {
        if (ventilationDriver == null) {
            throw new IllegalArgumentException("Cannot create command with null driver reference");
        }
        this.ventilationDriver = ventilationDriver;
    }

    @Override
    public void execute() {
        ventilationDriver.fanOff();
    }

    @Override
    public void undo() {
        ventilationDriver.fanOn();
    }
}

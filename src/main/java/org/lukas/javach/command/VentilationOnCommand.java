package org.lukas.javach.command;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class VentilationOnCommand implements Command {

    private VentilationDriver ventilationDriver;

    VentilationOnCommand(VentilationDriver ventilationDriver) {
        if (ventilationDriver == null) {
            throw new IllegalArgumentException("Cannot create command with null driver reference");
        }
        this.ventilationDriver = ventilationDriver;
    }

    @Override
    public void execute() {
        ventilationDriver.fanOn();
    }

    @Override
    public void undo() {
        ventilationDriver.fanOff();
    }
}

package org.lukas.javach.command;

/**
 * Created by Lukas on 29.10.2017.
 *
 * @author Lukas Pecak
 */
public class KitchenLightOnCommand implements Command {

    private KitchenLightDriver kitchenLightDriver;

    KitchenLightOnCommand(KitchenLightDriver kitchenLightDriver) {
        if (kitchenLightDriver == null) {
            throw new IllegalArgumentException("Cannot create command with null driver reference");
        }
        this.kitchenLightDriver = kitchenLightDriver;
    }

    @Override
    public void execute() {
        kitchenLightDriver.lightOn();
    }

    @Override
    public void undo() {
        kitchenLightDriver.lightOff();
    }
}

package org.lukas.javach.factory.abstractfactory;

import org.lukas.javach.factory.abstractfactory.ingredient.*;

/**
 * Created by Lukas on 22.10.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleToolIngredientFactory implements ToolIngredientFactory {

    @Override
    public Box createBox() {
        return new HardBox();
    }

    @Override
    public Tool createTool() {
        return new StealTool();
    }

    @Override
    public Warranty createWarranty() {
        return new DoorToDoorWarranty();
    }
}

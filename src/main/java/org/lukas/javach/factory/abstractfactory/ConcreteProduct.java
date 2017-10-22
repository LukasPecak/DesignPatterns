package org.lukas.javach.factory.abstractfactory;

import org.lukas.javach.factory.abstractfactory.ingredient.Box;
import org.lukas.javach.factory.abstractfactory.ingredient.Tool;
import org.lukas.javach.factory.abstractfactory.ingredient.Warranty;

/**
 * Created by Lukas on 22.10.2017.
 *
 * @author Lukas Pecak
 */
public class ConcreteProduct implements Product {

    private ToolIngredientFactory toolIngredientFactory;

    ConcreteProduct(ToolIngredientFactory toolIngredientFactory) {
        this.toolIngredientFactory = toolIngredientFactory;
    }

    @Override
    public Box getBox() {
        return toolIngredientFactory.createBox();
    }

    @Override
    public Tool getTool() {
        return toolIngredientFactory.createTool();
    }

    @Override
    public Warranty getWarranty() {
        return toolIngredientFactory.createWarranty();
    }
}

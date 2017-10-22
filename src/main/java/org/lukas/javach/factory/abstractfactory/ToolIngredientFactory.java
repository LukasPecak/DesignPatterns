package org.lukas.javach.factory.abstractfactory;

import org.lukas.javach.factory.abstractfactory.ingredient.Box;
import org.lukas.javach.factory.abstractfactory.ingredient.Tool;
import org.lukas.javach.factory.abstractfactory.ingredient.Warranty;

/**
 * Created by Lukas on 22.10.2017.
 *
 * @author Lukas Pecak
 */
public interface ToolIngredientFactory {

    Box createBox();

    Tool createTool();

    Warranty createWarranty();
}

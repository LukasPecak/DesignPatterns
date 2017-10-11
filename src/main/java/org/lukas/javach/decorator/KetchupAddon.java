package org.lukas.javach.decorator;

/**
 * Created by Lukas on 11.10.2017.
 *
 * @author Lukas Pecak
 */
public class KetchupAddon extends BeverageAbstractAddon {

    KetchupAddon(Beverage beverage) {
        super(beverage);
        description = "Ketchup";
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + description;
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1.2;
    }
}

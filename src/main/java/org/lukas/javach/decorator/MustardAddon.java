package org.lukas.javach.decorator;

/**
 * Created by Lukas on 11.10.2017.
 *
 * @author Lukas Pecak
 */
public class MustardAddon extends BeverageAbstractAddon {

    MustardAddon(Beverage beverage) {
        super(beverage);
        description = "Mustard";
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + description;
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 1.5;
    }
}

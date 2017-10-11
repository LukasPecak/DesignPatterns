package org.lukas.javach.decorator;

/**
 * Created by Lukas on 11.10.2017.
 *
 * @author Lukas Pecak
 */
abstract class BeverageAbstractAddon implements Beverage {

    Beverage beverage;
    String description;

    BeverageAbstractAddon(Beverage beverage) {
        this.beverage = beverage;
    }
}

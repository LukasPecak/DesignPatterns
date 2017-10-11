package org.lukas.javach.decorator;

/**
 * Created by Lukas on 11.10.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleBeverage2 implements Beverage {

    @Override
    public String getDescription() {
        return "Simple beverage 2";
    }

    @Override
    public double getCost() {
        return 12.9;
    }
}

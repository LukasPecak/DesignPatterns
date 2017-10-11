package org.lukas.javach.decorator;

/**
 * Created by Lukas on 11.10.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleBeverage1 implements Beverage {

    @Override
    public String getDescription() {
        return "Simple beverage 1";
    }

    @Override
    public double getCost() {
        return 9.9;
    }
}

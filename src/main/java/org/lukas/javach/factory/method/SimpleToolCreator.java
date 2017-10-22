package org.lukas.javach.factory.method;

import java.math.BigDecimal;

/**
 * Created by Lukas on 21.10.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleToolCreator extends Creator{

    @Override
    public void createProduct(String product, String name, BigDecimal price) {
        if ("wrench".equalsIgnoreCase(product)) {
            this.product = new Wrench(name, price);
            return;
        }
        if ("hammer".equalsIgnoreCase(product)) {
            this.product = new Hammer(name, price);
            return;
        }
        this.product = new NonProduct();
    }
}

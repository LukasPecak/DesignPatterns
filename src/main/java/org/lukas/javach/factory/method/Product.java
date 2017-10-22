package org.lukas.javach.factory.method;

import java.math.BigDecimal;

/**
 * Created by Lukas on 21.10.2017.
 *
 * @author Lukas Pecak
 */
public interface Product {

    String getName();

    BigDecimal getPrice();

    void viewProduct();

    void sellProduct();
}

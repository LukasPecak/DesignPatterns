package org.lukas.javach.factory.method;

import java.math.BigDecimal;

/**
 * Created by Lukas on 21.10.2017.
 *
 * @author Lukas Pecak
 */
public class Hammer extends AbstractProduct {

    Hammer(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void viewProduct() {
        log.info("Showing the product");
    }

    @Override
    public void sellProduct() {
        if (log.isInfoEnabled()) {
            log.info(String.format("Product %s - sold for %s", name, price));
        }
    }
}

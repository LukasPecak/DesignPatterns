package org.lukas.javach.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Created by Lukas on 21.10.2017.
 *
 * @author Lukas Pecak
 */
public abstract class Creator {

    private Logger log;
    Product product;

    Creator() {
        log = LoggerFactory.getLogger("Creator");
    }

    void performOperation() {
        if (log.isInfoEnabled()) {
            log.info(String.format("Performing operations for %s product", product.getName()));
        }
        product.viewProduct();
        product.sellProduct();
        log.info("End of operations");
    }

    public abstract void createProduct(String product, String name, BigDecimal price);
}

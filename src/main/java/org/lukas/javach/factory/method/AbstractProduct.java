package org.lukas.javach.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * Created by Lukas on 21.10.2017.
 *
 * @author Lukas Pecak
 */
abstract class AbstractProduct implements Product {

    Logger log;
    String name;
    BigDecimal price;

    AbstractProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.log = LoggerFactory.getLogger(name);
    }
}

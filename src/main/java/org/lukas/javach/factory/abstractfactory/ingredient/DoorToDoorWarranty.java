package org.lukas.javach.factory.abstractfactory.ingredient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 22.10.2017.
 *
 * @author Lukas Pecak
 */
public class DoorToDoorWarranty implements Warranty {

    private Logger log;

    public DoorToDoorWarranty() {
        log = LoggerFactory.getLogger(DoorToDoorWarranty.class);
    }

    @Override
    public void printDescription() {
        log.info("This product has a door to door warranty - do just relax and call our warranty service");
    }
}

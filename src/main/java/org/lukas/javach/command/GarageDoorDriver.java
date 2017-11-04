package org.lukas.javach.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 28.10.2017.
 *
 * @author Lukas Pecak
 */
class GarageDoorDriver {

    private static Logger log = LoggerFactory.getLogger(GarageDoorDriver.class);

    void openGarageDoor() {
        log.info("Garage door open");
    }

    void closeGarageDoor() {
        log.info("Garage door closed");
    }
}

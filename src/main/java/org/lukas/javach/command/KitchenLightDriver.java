package org.lukas.javach.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 28.10.2017.
 *
 * @author Lukas Pecak
 */
class KitchenLightDriver {

    private static Logger log = LoggerFactory.getLogger(KitchenLightDriver.class);

    void lightOn() {
        log.info("Light in kitchen on");
    }

    void lightOff() {
        log.info("Light in kitchen off");
    }
}

package org.lukas.javach.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 28.10.2017.
 *
 * @author Lukas Pecak
 */
class VentilationDriver {

    private static Logger log = LoggerFactory.getLogger(VentilationDriver.class);

    void fanOn() {
        log.info("Ventilation fan running ...");
    }

    void fanOff() {
        log.info("Ventilation fan disabled.");
    }
}

package org.lukas.javach.facade.subsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
public class Device3Impl implements Device3 {

    private static Logger log = LoggerFactory.getLogger(Device3.class);

    @Override
    public void executeSomething() {
        log.info("Executed some action");
    }

    @Override
    public void display() {
        log.info("Displayed information");
    }
}

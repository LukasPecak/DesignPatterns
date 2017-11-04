package org.lukas.javach.facade.subsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
public class Device1Impl implements Device1 {

    private static Logger log = LoggerFactory.getLogger(Device1.class);

    @Override
    public void performAction1() {
        log.info("Action 1 performed !");
    }

    @Override
    public void performAction2() {
        log.info("Action 2 performed !");
    }

    @Override
    public void performAction3() {
        log.info("Action 3 performed !");
    }
}

package org.lukas.javach.facade.subsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
public class Device2Impl implements Device2 {

    private static Logger log = LoggerFactory.getLogger(Device2.class);


    @Override
    public void doJob1() {
        log.info("Job 1 was done !");
    }

    @Override
    public void doJob2() {
        log.info("Job 2 was done !");
    }
}

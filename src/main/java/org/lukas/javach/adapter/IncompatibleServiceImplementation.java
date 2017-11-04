package org.lukas.javach.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
public class IncompatibleServiceImplementation implements IncompatibleService {

    private static Logger log = LoggerFactory.getLogger(IncompatibleService.class);

    @Override
    public void doFirstPartAction() {
        log.info("First partial action performed !");
    }

    @Override
    public void doSecondPartAction() {
        log.info("Second partial action performed !");
    }

    @Override
    public void display() {
        log.info("Display the object info : " + this.getClass().getSimpleName());
    }
}

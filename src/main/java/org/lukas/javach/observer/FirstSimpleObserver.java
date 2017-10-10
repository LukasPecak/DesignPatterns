package org.lukas.javach.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 09.10.2017.
 *
 * @author Lukas Pecak
 */
public class FirstSimpleObserver implements Observer {

    private static Logger log = LoggerFactory.getLogger(FirstSimpleObserver.class);

    @Override
    public void update() {
        log.info("Update from " + this.getClass().getName());
    }
}

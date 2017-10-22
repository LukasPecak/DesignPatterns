package org.lukas.javach.factory.abstractfactory.ingredient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 22.10.2017.
 *
 * @author Lukas Pecak
 */
public class HardBox implements Box {

    private Logger log;

    public HardBox() {
        log = LoggerFactory.getLogger(HardBox.class);
    }

    @Override
    public void printDescription() {
        log.info("A solid hard case for tool");
    }
}

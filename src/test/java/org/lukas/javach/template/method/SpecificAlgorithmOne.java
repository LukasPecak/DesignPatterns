package org.lukas.javach.template.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 06.11.2017.
 *
 * @author Lukas Pecak
 */
class SpecificAlgorithmOne extends TemplateAlgorithm {

    private static Logger log = LoggerFactory.getLogger(SpecificAlgorithmOne.class);

    @Override
    void prepare() {
        log.info("Specific algorithm one implementation of the prepare step ...");
    }

    @Override
    void executePrimaryAction() {
        log.info("Specific algorithm one implementation of the executePrimaryAction step ...");
    }
}

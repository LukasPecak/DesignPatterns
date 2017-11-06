package org.lukas.javach.template.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 06.11.2017.
 *
 * @author Lukas Pecak
 */
public class SpecificAlgorithmTwo extends TemplateAlgorithm {

    private static Logger log = LoggerFactory.getLogger(SpecificAlgorithmTwo.class);


    @Override
    void prepare() {
        log.info("Specific algorithm two implementation of the prepare step ...");
    }

    @Override
    void executePrimaryAction() {
        log.info("Specific algorithm two implementation of the executePrimaryAction step ...");
    }

    @Override
    protected void checkEndConditions() {
        log.info("Overridden the hock - this replaces the default implementation from the TemplateAlgorithm class ...");
    }
}

package org.lukas.javach.template.method;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 06.11.2017.
 *
 * @author Lukas Pecak
 */
public class TemplateAlgorithmTest {

    private static Logger log = LoggerFactory.getLogger(TemplateAlgorithmTest.class);

    private TemplateAlgorithm algorithm1;
    private TemplateAlgorithm algorithm2;

    @Before
    public void initialize() {
        algorithm1 = new SpecificAlgorithmOne();
        algorithm2 = new SpecificAlgorithmTwo();
    }

    @Test
    public void testIfAlgorithmStepsChangeForDifferentSubclasses() {
        log.info("\n\tRunning algorithm2 one : \n");
        algorithm1.templateMethod();
        log.info("\n\tRunning algorithm2 one : \n");
        algorithm2.templateMethod();
    }

}
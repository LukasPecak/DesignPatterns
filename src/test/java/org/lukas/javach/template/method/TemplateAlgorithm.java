package org.lukas.javach.template.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 06.11.2017.
 *
 * @author Lukas Pecak
 */
public abstract class TemplateAlgorithm {

    private static Logger log = LoggerFactory.getLogger(TemplateAlgorithm.class);

    /**
     * This is the implementation of the algorithm framework.
     * The template algorithm is declared as final to control the flow
     * at this class level (no algorithm steps modification possible)
     *
     * We have defined algorithm steps that are the same for the whole algorithm family like :
     * initialize()
     * executeSecondaryAction()
     *
     * We have two steps where we need to provide the implementation in the descendant classes like :
     * prepare()
     * executePrimaryAction()
     *
     * We also have steps in the algorithm framework known as hocks :
     * checkEndConditions()
     * that can be overridden but the must not be overridden because of their default implementation
     *
     * The template method pattern uses inheritance to implement different algorithms of the family -
     * similar to strategy pattern - but strategy uses composition instead.
     *
     */
    final void templateMethod() {
        initialize();
        prepare();
        executePrimaryAction();
        executeSecondaryAction();
        checkEndConditions();
    }

    /**
     * This step need to be implemented in the special algorithm class
     */
    abstract void prepare();

    /**
     * This step need to be implemented in the special algorithm class
     */
    abstract void executePrimaryAction();

    /**
     * This is the hock method. We can override this method in the subclass or use the default implementation provided here
     */
    protected void checkEndConditions() {
        log.info("Not overridden in subclass - performing the default step implementation ...");
    }

    /**
     * This method is universal across the whole algorithm family and cannot be modified in the subclass
     */
    private void initialize() {
        log.info("Initializing step of the algorithm ...");
    }

    /**
     * This method is universal across the whole algorithm family and cannot be modified in the subclass
     */
    private void executeSecondaryAction() {
        log.info("Executing the secondary action ...");
    }
}

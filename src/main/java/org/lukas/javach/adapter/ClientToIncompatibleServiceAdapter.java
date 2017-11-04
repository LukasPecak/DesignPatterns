package org.lukas.javach.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 04.11.2017.
 *
 * This is an object adapter. It adapts two incompatible interfaces to communicate each other.
 * It needs to implement the expected interface that the client knows how to use.
 * It invokes the adapted incompatible service methods using composition and method delegation.
 *
 * @author Lukas Pecak
 */
public class ClientToIncompatibleServiceAdapter implements ClientApi {

    private static Logger log = LoggerFactory.getLogger(ClientToIncompatibleServiceAdapter.class);

    private IncompatibleService incompatibleService;

    ClientToIncompatibleServiceAdapter(IncompatibleService incompatibleService) {
        this.incompatibleService = incompatibleService;
    }

    @Override
    public void doSomeAction() {
        incompatibleService.doFirstPartAction();
        incompatibleService.doSecondPartAction();
    }

    @Override
    public void printCurrentState(String message) {
        if (log.isInfoEnabled()) {
            log.info(String.format("The message is : %s , and now the incompatible service method will be executed", message));
        }
        incompatibleService.display();
    }
}

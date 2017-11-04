package org.lukas.javach.adapter;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
class ClientApiConsumer {

    private ClientApi clientApi;

    ClientApiConsumer(ClientApi clientApi) {
        this.clientApi = clientApi;
    }

    void runAction1() {
        clientApi.doSomeAction();
    }

    void runAction2(String message) {
        clientApi.printCurrentState(message);
    }
}

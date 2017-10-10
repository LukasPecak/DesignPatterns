package org.lukas.javach.observer;

/**
 * Created by Lukas on 10.10.2017.
 *
 * @author Lukas Pecak
 */
public class UniversalObserver implements Observer {

    private Runnable action;

    UniversalObserver(Runnable action) {
        this.action = action;
    }

    public UniversalObserver() {
    }

    @Override
    public void update() {
        action.run();
    }
}

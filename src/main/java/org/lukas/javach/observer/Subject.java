package org.lukas.javach.observer;

/**
 * Created by Lukas on 09.10.2017.
 *
 * @author Lukas Pecak
 */
interface Subject {

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();

    int getSubscribersNumber();
}

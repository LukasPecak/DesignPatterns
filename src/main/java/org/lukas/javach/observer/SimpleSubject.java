package org.lukas.javach.observer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lukas on 09.10.2017.
 *
 * @author Lukas Pecak
 */
public class SimpleSubject implements Subject {

    private Collection<Observer> subscribers;

    SimpleSubject(Collection<Observer> subscribers) {
        if (subscribers == null) {
            throw new IllegalArgumentException("Subscribers collection cannot be null!");
        }
        this.subscribers = subscribers;
    }

    public SimpleSubject() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        subscribers.forEach(Observer::update);
    }

    @Override
    public int getSubscribersNumber() {
        return subscribers.size();
    }

    @Override
    public String toString() {
        return "Subscribed observers : " + subscribers;
    }
}

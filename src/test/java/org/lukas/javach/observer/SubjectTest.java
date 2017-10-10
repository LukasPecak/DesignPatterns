package org.lukas.javach.observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lukas on 10.10.2017.
 *
 * @author Lukas Pecak
 */
public class SubjectTest {

    private static Logger log = LoggerFactory.getLogger(SubjectTest.class);

    private Subject subject;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        log.debug("Initializing fields before test runs ...");
        subject = new SimpleSubject(new ArrayList<>());
    }

    @Test
    public void addObserver() {
        log.debug("Adding new observer to existing subject");
        assertThat(subject.getSubscribersNumber(), is(equalTo(0)));
        subject.registerObserver(new FirstSimpleObserver());
        assertThat(subject.getSubscribersNumber(), is(equalTo(1)));
        subject.registerObserver(new SecondSimpleObserver());
        assertThat(subject.getSubscribersNumber(), is(equalTo(2)));
    }

    @Test
    public void removeObserver() {
        log.debug("Removing observer from existing subject");
        FirstSimpleObserver observer = new FirstSimpleObserver();
        subject.registerObserver(observer);
        assertThat(subject.getSubscribersNumber(), is(equalTo(1)));
        subject.unregisterObserver(observer);
        assertThat(subject.getSubscribersNumber(), is(equalTo(0)));
    }

    @Test
    public void checkIfObserversNotified() {
        log.debug("Check if the observers get notified by calling the notifyObservers() method on the subject");
        List<String> states = new ArrayList<>();
        subject.registerObserver(new UniversalObserver(() -> states.add(getClass().getSimpleName() + " 1 notified")));
        subject.registerObserver(new UniversalObserver(() -> states.add(getClass().getSimpleName() + " 2 notified")));
        assertThat(states.size(), is(equalTo(0)));
        subject.notifyObservers();
        assertThat(states.size(), is(equalTo(2)));
        log.info(states.toString());
        subject.notifyObservers();
        assertThat(states.size(), is(equalTo(4)));
        log.info(states.toString());
    }

    @Test
    public void tryNullArgumentConstructorThrowsException() {
        log.debug("Try if null collection constructor argument throws the IllegalArgumentException");
        thrown.expect(IllegalArgumentException.class);
        new SimpleSubject(null);
    }

    @Test
    public void checkIfUnregisterWorksAsExpected() {
        log.debug("Check the unregister of an observer for an existing subject");
        List<String> states = new ArrayList<>();
        UniversalObserver observer = new UniversalObserver(() -> states.add(getClass().getSimpleName() + " 1 notified"));
        subject.registerObserver(observer);
        assertThat(states.size(), is(equalTo(0)));
        subject.notifyObservers();
        assertThat(states.size(), is(equalTo(1)));
        subject.unregisterObserver(observer);
        subject.notifyObservers();
        assertThat(states.size(), is(equalTo(1)));
    }

    @Test
    public void testUpdatesForDifferentObservers() {
        log.debug("Check the update method for different kinds of observers");
        subject.registerObserver(new FirstSimpleObserver());
        subject.registerObserver(new SecondSimpleObserver());
        subject.registerObserver(new UniversalObserver(() -> log.info("This is the update from universal observer")));
        subject.notifyObservers();
    }
}
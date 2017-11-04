package org.lukas.javach.facade.subsystem;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.lukas.javach.facade.SubsystemFacade;
import org.lukas.javach.facade.UserOfSubsystemFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
public class FacadePatternImplementationTest {

    private static Logger log = LoggerFactory.getLogger(FacadePatternImplementationTest.class);

    private SubsystemFacade facade;
    private Device1 device1;
    private Device2 device2;
    private Device3 device3;

    @Before
    public void initialize() {
        device1 = new Device1Impl();
        device2 = new Device2Impl();
        device3 = new Device3Impl();
        facade = new UserOfSubsystemFacade(device1, device2,device3);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testTheAccessToSubsystemUsingFacade() {
        log.info("Run test for facade usage ...");
        facade.performSubsystemAction1();
        facade.performSubsystemAction2();
        facade.performSubsystemAction3();
    }

    @Test
    public void testDirectAccessToSubsystem() {
        log.info("Run test for direct access to subsystem devices ...");
        device1.performAction1();
        device1.performAction2();
        device1.performAction3();
        device2.doJob1();
        device2.doJob2();
        device3.executeSomething();
        device3.display();
    }

    @Test
    public void testNullPointerExceptionIsThrownForNullableDevices() {
        log.info("Run test for nullable subsystem device argument ...");
        facade = new UserOfSubsystemFacade(null, device2, device3);
        thrown.expect(NullPointerException.class);
        facade.performSubsystemAction1();
    }
}
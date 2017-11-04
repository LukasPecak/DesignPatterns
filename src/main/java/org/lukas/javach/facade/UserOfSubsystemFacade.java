package org.lukas.javach.facade;

import org.lukas.javach.facade.subsystem.Device1;
import org.lukas.javach.facade.subsystem.Device2;
import org.lukas.javach.facade.subsystem.Device3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
public class UserOfSubsystemFacade implements SubsystemFacade {

    private static Logger log = LoggerFactory.getLogger(SubsystemFacade.class);

    private Device1 device1;
    private Device2 device2;
    private Device3 device3;

    public UserOfSubsystemFacade(Device1 device1, Device2 device2, Device3 device3) {
        this.device1 = device1;
        this.device2 = device2;
        this.device3 = device3;
    }

    @Override
    public void performSubsystemAction1() {
        log.info("Performing action one on subsystem >");
        device1.performAction1();
        device1.performAction2();
        device3.display();
    }

    @Override
    public void performSubsystemAction2() {
        log.info("Performing action two on subsystem >");
        device1.performAction3();
        device2.doJob2();
    }

    @Override
    public void performSubsystemAction3() {
        log.info("Performing action three on subsystem >");
        device2.doJob1();
        device3.executeSomething();
        device1.performAction1();
    }
}

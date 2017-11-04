package org.lukas.javach;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.lukas.javach.command.CommandTest;
import org.lukas.javach.decorator.BeverageTest;
import org.lukas.javach.factory.abstractfactory.ProductTest;
import org.lukas.javach.factory.method.FactoryMethodTest;
import org.lukas.javach.observer.SubjectTest;
import org.lukas.javach.singleton.SingletonTest;

/**
 * Created by Lukas on 10.10.2017.
 *
 * @author Lukas Pecak
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        SubjectTest.class,
        BeverageTest.class,
        FactoryMethodTest.class,
        ProductTest.class,
        SingletonTest.class,
        CommandTest.class
})
public class TestSuite {}

package org.lukas.javach;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.lukas.javach.observer.SubjectTest;

/**
 * Created by Lukas on 10.10.2017.
 *
 * @author Lukas Pecak
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        SubjectTest.class
)
public class TestSuite {}

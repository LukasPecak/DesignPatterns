package org.lukas.javach.adapter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Lukas on 04.11.2017.
 *
 * @author Lukas Pecak
 */
public class AdapterPatternImplementationTest {

    private static Logger log = LoggerFactory.getLogger(AdapterPatternImplementationTest.class);

    private ClientApiConsumer clientApiConsumer;
    private ClientToIncompatibleServiceAdapter adapter;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        adapter = new ClientToIncompatibleServiceAdapter(new IncompatibleServiceImplementation());
        clientApiConsumer = new ClientApiConsumer(adapter);
    }

    @Test
    public void testAdapterInterfaceCompatibility() {
        log.info("Running adaptation test method ...");
        clientApiConsumer.runAction1();
        clientApiConsumer.runAction2("Invoked with adapter proxy");
    }

    @Test
    public void testIfNullPointerExceptionWillBeThrownForNullArgument() {
        log.info("Running null pointer exception thrown test ...");
        adapter = new ClientToIncompatibleServiceAdapter(null);
        clientApiConsumer = new ClientApiConsumer(adapter);
        thrown.expect(NullPointerException.class);
        clientApiConsumer.runAction2("Useless message");
        clientApiConsumer = new ClientApiConsumer(null);
        thrown.expect(NullPointerException.class);
        clientApiConsumer.runAction1();
    }

}
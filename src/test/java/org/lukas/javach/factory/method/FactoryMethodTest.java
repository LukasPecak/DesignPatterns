package org.lukas.javach.factory.method;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 21.10.2017.
 *
 * @author Lukas Pecak
 */
public class FactoryMethodTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Creator creator;

    @Before
    public void initialize() {
        creator = new SimpleToolCreator();
    }

    @Test
    public void createDifferentProducts() {
        creator.createProduct("wrench", "Snapon", new BigDecimal(100.0));
        creator.performOperation();

        creator.createProduct("HammEr", "Stanley", new BigDecimal(12.5));
        creator.performOperation();
    }

    @Test
    public void testIfUnknownProductThrowsUnsupportedOpertionException() {
        creator.createProduct(null, null, null);
        thrown.expect(UnsupportedOperationException.class);
        creator.performOperation();
    }
}
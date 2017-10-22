package org.lukas.javach.factory.abstractfactory;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.lukas.javach.factory.abstractfactory.ingredient.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by Lukas on 22.10.2017.
 *
 * @author Lukas Pecak
 */
public class ProductTest {

    private Logger log;
    private Product product;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        log = LoggerFactory.getLogger(ProductTest.class);
        product = new ConcreteProduct(new SimpleToolIngredientFactory());
    }

    @Test
    public void checkProductCreationProcess() {
        Box box  = new HardBox();
        Tool tool = new StealTool();
        Warranty warranty = new DoorToDoorWarranty();

        assertThat(product.getBox(), IsInstanceOf.instanceOf(box.getClass()));
        assertThat(product.getTool(), IsInstanceOf.instanceOf(tool.getClass()));
        assertThat(product.getWarranty(), IsInstanceOf.instanceOf(warranty.getClass()));

        product.getBox().printDescription();
        log.info(String.format("The quality test result is %s", product.getTool().isQualityApproved()));
        product.getWarranty().printDescription();
    }

    @Test
    public void checkForNullFactoryArgument() {
        product = new ConcreteProduct(null);
        thrown.expect(NullPointerException.class);
        product.getBox();
    }
}
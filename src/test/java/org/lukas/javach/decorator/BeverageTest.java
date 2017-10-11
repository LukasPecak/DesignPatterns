package org.lukas.javach.decorator;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lukas on 11.10.2017.
 *
 * @author Lukas Pecak
 */
public class BeverageTest {

    private static Logger log = LoggerFactory.getLogger(BeverageTest.class);

    private Beverage dish1;
    private Beverage dish2;

    @Before
    public void initialize() {
        log.debug("Initializing fields before test runs ...");
        dish1 = new SimpleBeverage1();
        dish2 = new SimpleBeverage2();
    }

    @Test
    public void createBaverage2WithMustardAndKetchup() {
        log.debug("Running test for wrapping the beverage with addons");
        Beverage dish = dish2;
        dish = new MustardAddon(dish);
        dish = new KetchupAddon(dish);
        log.info(dish.getDescription() + " - cost $ " + dish.getCost());
        assertThat(dish.getCost(), is(equalTo(15.6)));
        assertThat(dish.getDescription(), is(equalTo("Simple beverage 2, Mustard, Ketchup")));
        dish = dish1;
        dish = new KetchupAddon(dish);
        log.info(dish.getDescription() + " - cost $ " + dish.getCost());
        assertThat(dish.getCost(), is(equalTo(11.1)));
        assertThat(dish.getDescription(), is(equalTo("Simple beverage 1, Ketchup")));
    }

}
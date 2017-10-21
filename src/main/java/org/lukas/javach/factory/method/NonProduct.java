package org.lukas.javach.factory.method;

import java.math.BigDecimal;

/**
 * Created by Lukas on 21.10.2017.
 *
 * @author Lukas Pecak
 */
public class NonProduct implements Product {

    private static final UnsupportedOperationException UNSUPPORTED_OPERATION_EXCEPTION =
            new UnsupportedOperationException("This product does not exist !");

    @Override
    public String getName() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public BigDecimal getPrice() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public void viewProduct() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }

    @Override
    public void sellProduct() {
        throw UNSUPPORTED_OPERATION_EXCEPTION;
    }
}

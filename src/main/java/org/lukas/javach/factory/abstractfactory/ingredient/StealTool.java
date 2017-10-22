package org.lukas.javach.factory.abstractfactory.ingredient;

import java.util.Random;

/**
 * Created by Lukas on 22.10.2017.
 *
 * @author Lukas Pecak
 */
public class StealTool implements Tool {

    @Override
    public boolean isQualityApproved() {
        return new Random().nextBoolean();
    }
}

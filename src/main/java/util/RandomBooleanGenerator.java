package util;

import java.util.Random;

public class RandomBooleanGenerator implements BooleanGenerator {

    @Override
    public boolean get() {
        Random random = new Random();
        return random.nextBoolean();
    }
}

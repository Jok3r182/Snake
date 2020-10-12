package SnakeGame;

import java.util.Random;

public class RandomNumber {
    private static Random random = new Random();

    public static int generateRandomNumberFromZeroToHundred() {
        return random.nextInt(10) * 10 + 10;
    }

}

package Snake;

import java.util.Random;

public class RandomNumber {

    public static int generateRandomNumberFromZeroToHundred()
    {
        Random random = new Random();
        return  random.nextInt(10)*10;

    }

}
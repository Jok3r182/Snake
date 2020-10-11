package Snake;

import java.awt.*;
import java.util.Random;

public class GameSettings extends RandomNumber{



    public static final int appleValue = 10;
    public static final int goldenAppleValue=100;
    public static final int residueZero=0;
    public static int goldenAppleRate= generateRandomNumberFromZeroToHundred();

    public static final int difficultyEasy = 100;
    public static final int difficultyNormal = 70;
    public static final int difficultyHard = 30;

    public static final int backgroundWidth = 1700;
    public static final int backgroundHeight = 1500;

    public static final int hitboxSize = 30;

    public static final int snakeImgX = 64;
    public static final int snakeImgY = 64;

    public static final int foodImgX = 50;
    public static final int foodImgY = 50;

    public static final int wallImgX = 40;
    public static final int wallImgY = 40;

    public static final int distanceBetweenHeadingX = 50;
    public static final int distanceBetweenHeadingY = 100;

    public static final int forestImgPositionX = 0;
    public static final int getForestImgPositionY = 0;

    public static final Color scoreboardColor = new Color(153, 229, 80);

    public static final float fontSize = 30f;

}

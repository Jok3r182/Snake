package SnakeGame.Food;

import SnakeGame.Food.Food;
import SnakeGame.Level;
import SnakeGame.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import static SnakeGame.GameSettings.*;


public class Apple extends Food {

    public Apple(Map map) {
        super(map);
    }

    @Override
    public int getFoodValue() {
        return appleValue;
    }

    @Override
    public void renderObject(Graphics graphics, Level level) throws IOException {
        BufferedImage appleImg = ImageIO.read(new FileInputStream("src/img/food.png"));
        if (level.getScore().checkScore() % goldenAppleRate != residueZero || level.getScore().checkScore() == 0) {
            graphics.drawImage(appleImg, distanceBetweenHeadingX + getPosition().getX() * hitboxSize, distanceBetweenHeadingY + getPosition().getY() * hitboxSize, foodImgX, foodImgY, null);
        }
    }
}

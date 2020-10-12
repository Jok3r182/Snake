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

public class GoldenApple extends Food {

    public GoldenApple(Map map) {
        super(map);
    }

    @Override
    public int getFoodValue() {
        return goldenAppleValue;
    }

    @Override
    public void renderObject(Graphics graphics, Level level) throws IOException {
        BufferedImage goldenAppleImg = ImageIO.read(new FileInputStream("src/img/goldenapple.png"));
        if (level.getScore().checkScore() % goldenAppleRate == residueZero && level.getScore().checkScore() != 0) {
            graphics.drawImage(goldenAppleImg, distanceBetweenHeadingX + getPosition().getX() * hitboxSize, distanceBetweenHeadingY + getPosition().getY() * hitboxSize, foodImgX, foodImgY, null);
        }
    }
}

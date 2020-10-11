package Snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import static Snake.GameSettings.*;

public class Renderer extends JPanel {
    private final BufferedImage snakeImage;
    private final BufferedImage foodImage;
    private final BufferedImage wallImage;
    private final BufferedImage forestImg;
    private final BufferedImage tailImg;
    private final BufferedImage goldenApple;

    public Renderer() throws IOException {
        snakeImage = ImageIO.read(new FileInputStream("src/img/snakeSpriteNr2.png"));
        foodImage = ImageIO.read(new FileInputStream("src/img/food.png"));
        goldenApple = ImageIO.read(new FileInputStream("src/img/goldenapple.png"));
        wallImage = ImageIO.read(new FileInputStream("src/img/wall.png"));
        forestImg = ImageIO.read(new FileInputStream("src/img/Forest.png"));
        tailImg = ImageIO.read(new FileInputStream("src/img/tailSnake.png"));
    }

    public void render(Graphics g, Level lvl) {
        super.paintComponent(g);
        g.drawImage(forestImg, forestImgPositionX, getForestImgPositionY, backgroundWidth, backgroundHeight, null);
        if (!lvl.getSnake().getTailPositions().isEmpty()) {
            for (Position pos : lvl.getSnake().getTailPositions()) {
                g.drawImage(tailImg, distanceBetweenHeadingX + pos.getX() * hitboxSize, distanceBetweenHeadingY + pos.getY() * hitboxSize, snakeImgX, snakeImgY, null);
            }
        }
        g.drawImage(snakeImage, distanceBetweenHeadingX + lvl.getSnake().getPosition().getX() * hitboxSize, distanceBetweenHeadingY + lvl.getSnake().getPosition().getY() * hitboxSize, snakeImgX, snakeImgY, null);



        if (lvl.getScore().checkScore()%goldenAppleRate==residueZero&&lvl.getScore().checkScore()!=0) {
            g.drawImage(goldenApple, distanceBetweenHeadingX + lvl.getGoldenApple().getPosition().getX() * hitboxSize, distanceBetweenHeadingY + lvl.getGoldenApple().getPosition().getY() * hitboxSize, foodImgX, foodImgY, null);
        }
        else
        {
            g.drawImage(foodImage, distanceBetweenHeadingX + lvl.getApple().getPosition().getX() * hitboxSize, distanceBetweenHeadingY + lvl.getApple().getPosition().getY() * hitboxSize, foodImgX, foodImgY, null);
        }

        for (int y = 0; y < lvl.getMap().width(); y++) {
            for (int x = 0; x < lvl.getMap().height(); x++)
                if (lvl.getMap().isWall(y, x))
                    g.drawImage(wallImage, distanceBetweenHeadingX + x * hitboxSize, distanceBetweenHeadingY + y * hitboxSize, wallImgX, wallImgY, null);//bloko x ir y dydis
        }
    }
}

package Snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Renderer extends JPanel {
    private final BufferedImage snakeImage;
    private final BufferedImage foodImage;
    private final BufferedImage wallImage;
    private final BufferedImage forestImg;
    private final BufferedImage tailImg;

    public Renderer() throws IOException {
        snakeImage = ImageIO.read(new FileInputStream("src/img/snakeSpriteNr2.png"));
        foodImage = ImageIO.read(new FileInputStream("src/img/food.png"));
        wallImage = ImageIO.read(new FileInputStream("src/img/wall.png"));
        forestImg = ImageIO.read(new FileInputStream("src/img/Forest.png"));
        tailImg = ImageIO.read(new FileInputStream("src/img/tailSnake.png"));
    }

    public void render(Graphics g, Level lvl) {
        super.paintComponent(g);
        g.drawImage(forestImg, 0, 0, 1700, 1500, null);
        if (!lvl.getSnake().getPositions().isEmpty()) {
            for (Position pos : lvl.getSnake().getPositions()) {
                g.drawImage(tailImg, 50 + pos.getX() * 30, 100 + pos.getY() * 30, 64, 64, null);
            }
        }
        g.drawImage(snakeImage, 50 + lvl.getSnake().getPosition().getX() * 30, 100 + lvl.getSnake().getPosition().getY() * 30, 64, 64, null);

        g.drawImage(foodImage, 50 + lvl.getFood().getPosition().getX() * 30, 100 + lvl.getFood().getPosition().getY() * 30, 50, 50, null);
        for (int y = 0; y < lvl.getMap().width(); y++) {
            for (int x = 0; x < lvl.getMap().height(); x++)
                if (lvl.getMap().isWall(y, x))
                    g.drawImage(wallImage, 50 + x * 30, 100 + y * 30, 40, 40, null);//bloko x ir y dydis
        }
    }
}

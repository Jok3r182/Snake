package SnakeGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static SnakeGame.GameSettings.*;

public class Renderer extends JPanel {
    private final BufferedImage forestImg;
    private ArrayList<ObjectRendered> allObjectsRendered= new ArrayList<>();

    public Renderer() throws IOException {
        forestImg = ImageIO.read(new FileInputStream("src/img/Forest.png"));
    }
    public void addObjectsToRenderer(ObjectRendered objectRendered)
    {
        allObjectsRendered.add(objectRendered);
    }

    public void render(Graphics g, Level lvl) throws IOException {
        super.paintComponent(g);
        g.drawImage(forestImg, forestImgPositionX, getForestImgPositionY, backgroundWidth, backgroundHeight, null);

        for (ObjectRendered objectRendered: allObjectsRendered)
        {
            objectRendered.renderObject(g, lvl);
        }

    }

}

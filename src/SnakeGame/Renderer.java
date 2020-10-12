package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static SnakeGame.GameSettings.*;

public class Renderer extends JPanel {

    private Image icon;
    private ArrayList<ObjectRendered> allObjectsRendered= new ArrayList<>();

    public Renderer() throws IOException {
         icon = new ImageIcon(new URL("https://i.pinimg.com/originals/b3/48/fd/b348fd7e8ebf92d40b4394f203c55154.gif")).getImage();

    }

    public void addObjectsToRenderer(ObjectRendered objectRendered)
    {
        allObjectsRendered.add(objectRendered);
    }

    public void render(Graphics g, Level lvl) throws IOException {
        super.paintComponent(g);

        g.drawImage(icon, forestImgPositionX, getForestImgPositionY, backgroundWidth, backgroundHeight, null);

        for (ObjectRendered objectRendered: allObjectsRendered)
        {
            objectRendered.renderObject(g, lvl);
        }

    }

}

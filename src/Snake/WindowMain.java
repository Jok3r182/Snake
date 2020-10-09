package Snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;


public class WindowMain extends JPanel{

    private final BufferedImage snakeImage;
    private final BufferedImage foodImage;
    private final BufferedImage wallImage;
    private final BufferedImage forest;
    private final BufferedImage tail;
    private Rules rules;
    private Level lvl;
    private char command=0;
    private char tempCommand;

    public WindowMain() throws IOException {
        Map map = new Map();
        Random rand= new Random();
        Snake snake = new Snake(new Position(rand.nextInt(map.getGameMap()[0].length-2)+1, rand.nextInt(map.getGameMap().length-2)+1));
        Food food = new Food(new Position(rand.nextInt(map.getGameMap()[0].length-2)+1, rand.nextInt(map.getGameMap().length-2)+1));
        this.lvl = new Level(snake, map, food);
         this.rules = new Rules(lvl);
        snakeImage=ImageIO.read(new FileInputStream("src/img/snakeSpriteNr3.png"));
        foodImage=ImageIO.read(new FileInputStream("src/img/food.png"));
        wallImage=ImageIO.read(new FileInputStream("src/img/wall.png"));
        forest=ImageIO.read(new FileInputStream("src/img/Forest.png"));
        tail=ImageIO.read(new FileInputStream("src/img/tailSnake.png"));
        super.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                tempCommand = e.getKeyChar();
                if (((command== 'w' && tempCommand != 's') || (command == 's' && tempCommand != 'w'))||((command== 'd' && tempCommand != 'a') || (command == 'a' && tempCommand != 'd'))) {//atvejui jei einant žėmyn bandoma eit aukštyn ir atv.
                    command = tempCommand;
                }
                if (command==0)
                {
                    command=tempCommand;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        
        ActionListener actionListener = new ActionListener() {//tam tikro mygtuko paspaudimu pradeda judėt į command kryptį
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                repaint();

                rules.processUserInput(command);
                rules.foodIsEaten();
                rules.mapCollision();
                rules.tailIsHit();
                rules.infoBox("Game Over", "", rules.isGameOver());
            }
        };
        javax.swing.Timer time = new Timer(100, actionListener);
        time.start();
        setFocusable(true);
        requestFocusInWindow();

    }
    public BufferedImage rotate(BufferedImage bimg, double angle) {

        int w = bimg.getWidth();
        int h = bimg.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, bimg.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(Math.toRadians(angle), w/2, h/2);
        graphic.drawImage(bimg, null, 0, 0);
        graphic.dispose();
        return rotated;
    }
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(forest, 0, 0, 1700, 1500, null);
        if (!lvl.getSnake().getPositions().isEmpty()) {
            for (Position pos : lvl.getSnake().getPositions()) {
                g.drawImage(tail, 50 + pos.getX() * 30, 50 + pos.getY() * 30, 64, 64, null);
            }
        }
        g.drawImage(snakeImage, 50 + lvl.getSnake().getPosition().getX() * 30, 50 + lvl.getSnake().getPosition().getY() * 30, 64, 64, null);

       g.drawImage(foodImage, 50+lvl.getFood().getPosition().getX()*30, 50+lvl.getFood().getPosition().getY()*30, 50, 50, null);
        for (int y = 0; y < lvl.getMap().width(); y++) {
            for (int x = 0; x < lvl.getMap().height(); x++)
                if (lvl.getMap().isWall(y, x))
                    g.drawImage(wallImage, 50 + x*30, 50 + y*30, 40, 40, null);//bloko x ir y dydis
        }
    }
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                try {
                    JFrame frame = new JFrame();
                    frame.setPreferredSize(new Dimension(1700, 1500));
                    frame.pack();
                    frame.setContentPane(new WindowMain());
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

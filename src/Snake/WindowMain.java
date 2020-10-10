package Snake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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

    public WindowMain() throws IOException, FontFormatException {
        Map map = new Map();
        Random rand= new Random();
        Snake snake = new Snake(new Position(rand.nextInt(map.getGameMap()[0].length-2)+1, rand.nextInt(map.getGameMap().length-2)+1));
        Food food = new Food(new Position(rand.nextInt(map.getGameMap()[0].length-2)+1, rand.nextInt(map.getGameMap().length-2)+1));
        Score score = new Score(food);
        this.lvl = new Level(snake, map, food, score);
         this.rules = new Rules(lvl);

        snakeImage=ImageIO.read(new FileInputStream("src/img/snakeSpriteNr2.png"));
        foodImage=ImageIO.read(new FileInputStream("src/img/food.png"));
        wallImage=ImageIO.read(new FileInputStream("src/img/wall.png"));
        forest=ImageIO.read(new FileInputStream("src/img/Forest.png"));
        tail=ImageIO.read(new FileInputStream("src/img/tailSnake.png"));

        JLabel scoreboard = new JLabel();
        Font font =Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Terasong-mLZ3a.ttf")).deriveFont(30f);
        Color color= new Color(153,229,80);
        scoreboard.setFont(font);
        scoreboard.setForeground(color);

        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);//html nemato font, reikia jį registruoti JRE

        super.add(scoreboard);
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

        //tam tikro mygtuko paspaudimu pradeda judėt į command kryptį
        ActionListener actionListener = actionEvent -> {
            repaint();

            rules.processUserInput(command);
            rules.foodIsEaten();
            rules.mapCollision();
            rules.tailIsHit();
            scoreboard.setText("<html>"+"Score: "+ lvl.getScore().getScore()+"<br/>"+" HighScore: "+lvl.getScore().getHighScore()+"</html>");
            rules.infoBox("Game Over"+"\n"+"Your score: "+lvl.getScore().getScore()+"\nYour Highest Score: "+lvl.getScore().getHighScore(), "", rules.isGameOver());
        };

        javax.swing.Timer time = new Timer(100, actionListener);
        time.start();
        setFocusable(true);
        requestFocusInWindow();

    }

    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(forest, 0, 0, 1700, 1500, null);
        if (!lvl.getSnake().getPositions().isEmpty()) {
            for (Position pos : lvl.getSnake().getPositions()) {
                g.drawImage(tail, 50 + pos.getX() * 30, 100 + pos.getY() * 30, 64, 64, null);
            }
        }
        g.drawImage(snakeImage, 50 + lvl.getSnake().getHeadPosition().getX() * 30, 100 + lvl.getSnake().getHeadPosition().getY() * 30, 64, 64, null);

       g.drawImage(foodImage, 50+lvl.getFood().getPosition().getX()*30, 100+lvl.getFood().getPosition().getY()*30, 50, 50, null);
        for (int y = 0; y < lvl.getMap().width(); y++) {
            for (int x = 0; x < lvl.getMap().height(); x++)
                if (lvl.getMap().isWall(y, x))
                    g.drawImage(wallImage, 50 + x*30, 100 + y*30, 40, 40, null);//bloko x ir y dydis
        }
    }
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
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
        });
    }
}

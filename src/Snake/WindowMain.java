package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static Snake.GameSettings.*;

public class WindowMain extends JPanel{

    private Rules rules;
    private Level lvl;
    private Renderer renderer;
    private char command=0;
    private char tempCommand;

    public WindowMain() throws IOException, FontFormatException {
        Map map = new Map();
        Snake snake = new Snake(map);
        Food food = new Food(map);
        Score score = new Score(food);

        this.lvl = new Level(snake, map, food, score);
        this.rules = new Rules(lvl);

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
                if (e.getKeyChar()=='w'||e.getKeyChar()=='s'||e.getKeyChar()=='d'||e.getKeyChar()=='a') {
                    tempCommand = e.getKeyChar();
                    if (((command == 'w' && tempCommand != 's') || (command == 's' && tempCommand != 'w')) || ((command == 'd' && tempCommand != 'a') || (command == 'a' && tempCommand != 'd'))) {//atvejui jei einant žėmyn bandoma eit aukštyn ir atv.
                        command = tempCommand;
                    }
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

        javax.swing.Timer time = new Timer(difficultyNormal, actionListener);
        time.start();
        setFocusable(true);
        requestFocusInWindow();

       this.renderer = new Renderer();

    }

    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        this.renderer.render(g, lvl);
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

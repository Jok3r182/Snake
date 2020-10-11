package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static Snake.GameSettings.*;

public class WindowMain extends JPanel {

    private Rules rules;
    private Level lvl;
    private Renderer renderer;
    private char command = 0;
    private char tempCommand;

    public WindowMain() throws IOException, FontFormatException {
        Map map = new Map();
        Snake snake = new Snake(map);
        Apple apple = new Apple(map);
        Score score = new Score(apple);

        this.lvl = new Level(snake, map, apple, score);
        this.rules = new Rules(lvl);

        JLabel scoreboard = new JLabel();
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Terasong-mLZ3a.ttf")).deriveFont(fontSize);

        scoreboard.setFont(font);
        scoreboard.setForeground(scoreboardColor);

        GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);//html nemato font, reikia jį registruoti JRE

        super.add(scoreboard);
        super.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (checkIfCorrectKeyWasPressed(e.getKeyChar())) {
                    tempCommand = e.getKeyChar();
                    //atvejui jei einant žėmyn bandoma eit aukštyn ir atv.
                    if (((command == 'w' && tempCommand != 's') || (command == 's' && tempCommand != 'w')) || ((command == 'd' && tempCommand != 'a') || (command == 'a' && tempCommand != 'd'))) {
                        command = tempCommand;
                    }
                }
                if (command == 0) {
                    command = tempCommand;
                }
            }
        });

        //tam tikro mygtuko paspaudimu pradeda judėt į command kryptį
        ActionListener actionListener = actionEvent -> {
            repaint();
            rules.processUserInput(command);
            rules.foodIsEaten();
            rules.mapCollision();
            rules.tailIsHit();
            scoreboard.setText("<html>" + "Score: " + lvl.getScore().getScore() + "<br/>" + " HighScore: " + lvl.getScore().getHighScore() + "</html>");
            rules.infoBox("Game Over" + "\n" + "Your score: " + lvl.getScore().getScore() + "\nYour Highest Score: " + lvl.getScore().getHighScore(), "", rules.isGameOver());
        };

        javax.swing.Timer time = new Timer(difficultyNormal, actionListener);
        time.start();
        setFocusable(true);
        requestFocusInWindow();

        this.renderer = new Renderer();

    }

    public boolean checkIfCorrectKeyWasPressed(char c) {
        return c == 'w' || c == 's' || c == 'a' || c == 'd'||c=='q';
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.renderer.render(g, lvl);
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(() -> {
            try {
                JFrame frame = new JFrame();
                frame.setPreferredSize(new Dimension(backgroundWidth, backgroundHeight));
                frame.pack();
                frame.setContentPane(new WindowMain());
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

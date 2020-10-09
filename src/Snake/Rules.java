package Snake;

import javax.swing.*;
import java.util.Random;

public class Rules {
    private Level level;
    private boolean gameOver = false;
    private boolean foodEaten = false;
    public Rules(Level level) {
        this.level = level;
    }

    public void processUserInput(int key) {
        switch (key) {
            case 'w':
                int y = level.getSnake().getHeadPosition().getY();
                int tpos1;
                level.getSnake().snakeUnitMovement();
                level.getSnake().getHeadPosition().setY(--y);

                /*for (int i=0; i<level.getSnake().getPositions().size(); i++)
                {
                    tpos1=level.getSnake().getPositions().get(i).getY();
                    level.getSnake().getPositions().get(i).setY(y);
                    y=tpos1;
                }*/
                break;
            case 's':
                int y1 = level.getSnake().getHeadPosition().getY();
                level.getSnake().snakeUnitMovement();
                level.getSnake().getHeadPosition().setY(++y1);
              /*  for (int i=0; i<level.getSnake().getPositions().size(); i++)
                {
                    tpos1=level.getSnake().getPositions().get(i).getY();
                    level.getSnake().getPositions().get(i).setY(y1);
                    y1=tpos1;
                }*/
                break;
            case 'a':
                int tpos3;
                int x = level.getSnake().getHeadPosition().getX();
                level.getSnake().snakeUnitMovement();
                level.getSnake().getHeadPosition().setX(--x);
               /* for (int i=0; i<level.getSnake().getPositions().size(); i++)
                {
                    tpos3=level.getSnake().getPositions().get(i).getX();
                    level.getSnake().getPositions().get(i).setX(x);
                    x=tpos3;
                }*/
                break;
            case 'd':
                int x1 = level.getSnake().getHeadPosition().getX();
                level.getSnake().snakeUnitMovement();
                level.getSnake().getHeadPosition().setX(++x1);

                /*for (int i=0; i<level.getSnake().getPositions().size(); i++)
                {
                    tpos3=level.getSnake().getPositions().get(i).getX();
                    level.getSnake().getPositions().get(i).setX(x1);
                    x1=tpos3;
                }*/
                break;
            case 'q':
                setGameOver(true);
                break;
        }
    }

    public void foodIsEaten() {
        Random rand = new Random();
        if (level.getSnake().getHeadPosition().getY() == level.getFood().getPosition().getY() && level.getSnake().getHeadPosition().getX() == level.getFood().getPosition().getX()) {
            level.getSnake().increaseTailLength();
            level.getSnake().addPositions(new Position(level.getSnake().getHeadPosition()));
            level.getFood().getPosition().setX(rand.nextInt(level.getMap().height() - 2) + 1);
            level.getFood().getPosition().setY(rand.nextInt(level.getMap().width() - 2) + 1);
            level.getScore().scored();
            foodEaten=true;
        }
        else
        {
            foodEaten=false;
        }
    }

    public boolean isFoodEaten()
    {
        return foodEaten;
    }

    public void mapCollision()
    {
        if (level.getMap().getGameMap()[level.getSnake().getHeadPosition().getY()][level.getSnake().getHeadPosition().getX()] == 1) {
            gameOver = true;
        }
    }
    public void tailIsHit()
    {
        for (Position pos: level.getSnake().getPositions())
        {
            if ((level.getSnake().getHeadPosition().getY()==(pos.getY()))&&(level.getSnake().getHeadPosition().getX()==pos.getX())&&isFoodEaten()!=true)//isFoodEaten, nes kuomet suvalgome 1 koordinatė sutampa
            {
                gameOver=true;
            }
        }
    }
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void infoBox(String infoMessage, String titleBar, boolean gameOver) {
        if (gameOver) {
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}

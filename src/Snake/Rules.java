package Snake;

import javax.swing.*;

import static Snake.GameSettings.*;

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
                level.getSnake().snakeTailMovement();
                level.getSnake().setPosition(level.getSnake().getPosition().up());
                break;
            case 's':
                level.getSnake().snakeTailMovement();
                level.getSnake().setPosition(level.getSnake().getPosition().down());
                break;
            case 'a':
                level.getSnake().snakeTailMovement();
                level.getSnake().setPosition(level.getSnake().getPosition().left());
                break;
            case 'd':
                level.getSnake().snakeTailMovement();
                level.getSnake().setPosition(level.getSnake().getPosition().right());
                break;
            case 'q':
                setGameOver(true);
                break;
        }
    }

   public void setApple(Food food)
   {
       level.setFood(food);
       level.getScore().setFood(food);
       food.setNewPosition();
   }


    public void spawnApple()
    {
        if (level.getScore().checkScore()%goldenAppleRate==residueZero&&level.getScore().checkScore()!=0)
        {
            setApple(level.getGoldenApple());
        }
        else
        {
           setApple(level.getApple());
        }
    }

    public void foodIsEaten() {
            if (level.getSnake().getPosition().getY() == level.getFood().getPosition().getY() && level.getSnake().getPosition().getX() ==level.getFood().getPosition().getX()) {
                level.getSnake().addTail(new Position(level.getSnake().getPosition()));
                level.getScore().scored();
                spawnApple();
                foodEaten = true;
            } else {
                foodEaten = false;
            }

    }

    public boolean isFoodEaten() {
        return foodEaten;
    }

    public void mapCollision() {
        if (level.getMap().getGameMap()[level.getSnake().getPosition().getY()][level.getSnake().getPosition().getX()] == 1) {
            gameOver = true;
        }
    }

    public void tailIsHit() {
        for (Position pos : level.getSnake().getTailPositions()) {
            if ((level.getSnake().getPosition().getY() == (pos.getY())) && (level.getSnake().getPosition().getX() == pos.getX()) && !isFoodEaten())//isFoodEaten, nes kuomet suvalgome 1 koordinatė sutampa
            {
                gameOver = true;
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
            level.getScore().saveHighScore();
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}

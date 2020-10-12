package SnakeGame;

import SnakeGame.Food.Food;

import javax.swing.*;

import static SnakeGame.GameSettings.*;

public class Rules {
    private Level level;
    private boolean gameOver = false;
    private boolean foodEaten = false;
    private static Rules instance;


    public Rules(Level level) {
        this.level = level;
    }

    public void exitGame() {
        setGameOver(true);
    }

    public void moveRight() {
        level.getSnake().snakeTailMovement();
        level.getSnake().setPosition(level.getSnake().getPosition().right());
    }

    public void moveLeft() {
        level.getSnake().snakeTailMovement();
        level.getSnake().setPosition(level.getSnake().getPosition().left());
    }

    public void moveDown() {
        level.getSnake().snakeTailMovement();
        level.getSnake().setPosition(level.getSnake().getPosition().down());
    }

    public void moveUp() {
        level.getSnake().snakeTailMovement();
        level.getSnake().setPosition(level.getSnake().getPosition().up());
    }

    public void setApple(Food food)
   {
       level.setFood(food);
       level.getScore().setFood(food);
       food.setNewPosition();
   }


    public void spawnApple()
    {
        if (level.getScore().checkScore()!=0&&level.getScore().checkScore()%goldenAppleRate==residueZero)
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
        if (!level.getMap().isAvailable(level.getSnake().getPosition())) {
            gameOver = true;
        }
    }

    public void tailIsHit() {
        for (Position pos : level.getSnake().getTailPositions()) {
            if ((level.getSnake().getPosition().getY() == (pos.getY())) && (level.getSnake().getPosition().getX() == pos.getX()) && !isFoodEaten())//isFoodEaten, nes kuomet suvalgome 1 koordinatė sutampa
            {
                gameOver = true;
                break;
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

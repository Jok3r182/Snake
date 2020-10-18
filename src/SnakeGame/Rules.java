package SnakeGame;

import SnakeGame.Food.Food;

import javax.swing.*;

import static SnakeGame.GameSettings.*;

public class Rules {
    private Level level;
    private boolean gameOver = false;
    private boolean foodEaten = false;


    public Rules(Level level) {
        this.level = level;
    }

    public void exitGame() {
        setGameOver(true);
    }

    public void moveRight() {
        level.getSnakeTailMovement();
        level.setSnakePosition(level.getSnakeRightPosition());
    }

    public void moveLeft() {
        level.getSnakeTailMovement();
        level.setSnakePosition(level.getSnakeLeftPosition());
    }

    public void moveDown() {
        level.getSnakeTailMovement();
        level.setSnakePosition(level.getSnakeDownPosition());
    }

    public void moveUp() {
        level.getSnakeTailMovement();
        level.setSnakePosition(level.getSnakeUpperPosition());
    }

    public void setApple(Food food)
   {
       level.setFood(food);
       level.setFoodForScore(food);
       food.setNewPosition();
       if (checkIfTailIsHit(food.getPositionX(), food.getPositionY()))
       {
           food.setNewPosition();
       }
   }


    public void spawnApple()
    {
        if (level.checkScore()!=0&&level.checkScore()%goldenAppleRate==residueZero)
        {
            setApple(level.getGoldenApple());
        }
        else
        {
           setApple(level.getApple());
        }
    }

    public void foodIsEaten() {
            if (level.getSnakeHeadCoordinateY()== level.getFoodCoordinateY() && level.getSnakeHeadCoordinateX() ==level.getFoodCoordinateX()) {
                level.addSnakeTail(new Position(level.getSnakePosition()));
                level.addScore();
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
        if (!level.isMapAvailable(level.getSnakePosition())) {
            gameOver = true;
        }
    }

    public boolean checkIfTailIsHit(int x, int y)
    {   Boolean isHit = false;
        for (Position tailPosition : level.getTailPositions()) {
            if ((y == (tailPosition.getY())) && (x == tailPosition.getX()))//isFoodEaten, nes kuomet suvalgome 1 koordinatė sutampa
            {
                isHit=true;
            }
        }
        return isHit;
    }


    public void tailIsHit() {
            if (checkIfTailIsHit(level.getSnakeHeadCoordinateX(), level.getSnakeHeadCoordinateY()) && !isFoodEaten())//isFoodEaten, nes kuomet suvalgome 1 koordinatė sutampa
            {
                gameOver = true;
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
            level.saveHighScore();
            JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
}

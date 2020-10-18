package SnakeGame;

import SnakeGame.Food.Apple;
import SnakeGame.Food.Food;
import SnakeGame.Food.GoldenApple;
import SnakeGame.Snake.Snake;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private Snake snake;
    private Map map;
    private Apple apple;
    private GoldenApple goldenApple;
    private Food food;
    private Score score;

    public Level(Snake snake, Map map, Apple apple, GoldenApple goldenApple, Score score) {
        setSnake(snake);
        setMap(map);
        setGoldenApple(goldenApple);
        setApple(apple);
        setFood(apple);
        setScore(score);
    }

    public void getSnakeTailMovement() {
        this.snake.snakeTailMovement();
    }

    public Position setSnakePosition(Position position) {
        return this.snake.setPosition(position);
    }

    public Position getSnakeUpperPosition() {
        return snake.positionUp();
    }

    public void setSnakePosition(int x, int y)
    {
        snake.setPosition(x, y);
    }

    public void setApplePosition(int x, int y)
    {
        apple.setPosition(x, y);
    }

    public Position getSnakeDownPosition() {
        return snake.positionDown();
    }

    public Position getSnakeLeftPosition() {
        return snake.positionLeft();
    }

    public Position getSnakeRightPosition() {
        return snake.positionRight();
    }

    public int checkScore() {
        return score.checkScore();
    }

    public void setFoodForScore(Food food) {
        score.setFood(food);
    }

    public int getSnakeHeadCoordinateX()
    {
        return snake.getPositionX();
    }

    public int getSnakeHeadCoordinateY()
    {
        return snake.getPositionY();
    }

    public int getFoodCoordinateX()
    {
        return food.getPositionX();
    }

    public int getFoodCoordinateY()
    {
        return food.getPositionY();
    }

    public Position getSnakePosition()
    {
        return snake.getPosition();
    }

    public void addScore()
    {
        score.scored();
    }

    public boolean isMapAvailable(Position position)
    {
        return map.isAvailable(position);
    }

    public void addSnakeTail(Position position)
    {
        snake.addTail(position);
    }

    public void saveHighScore()
    {
        score.saveHighScore();
    }

    public int getHighScore()
    {
        return score.getHighScore();
    }

    public List<Position> getTailPositions()
    {
       return snake.getTailPositions();
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public GoldenApple getGoldenApple() {
        return goldenApple;
    }

    public void setGoldenApple(GoldenApple goldenApple) {
        this.goldenApple = goldenApple;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

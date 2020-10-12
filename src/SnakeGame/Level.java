package SnakeGame;

import SnakeGame.Food.Apple;
import SnakeGame.Food.Food;
import SnakeGame.Food.GoldenApple;
import SnakeGame.Snake.Snake;

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

    public Food getFood() {
        return food;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

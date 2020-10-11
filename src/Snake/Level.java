package Snake;

public class Level {
    private Snake snake;
    private Map map;
    private Apple apple;
    private Score score;

    public Level(Snake snake, Map map, Apple apple, Score score) {
        setSnake(snake);
        setMap(map);
        setFood(apple);
        setScore(score);
    }

    public Apple getFood() {
        return apple;
    }

    public void setFood(Apple apple) {
        this.apple = apple;
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

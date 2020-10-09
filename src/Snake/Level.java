package Snake;

public class Level {
    private Snake snake;
    private Map map;
    private Food food;
    public Level(Snake snake, Map map, Food food)
    {
        setSnake(snake);
        setMap(map);
        setFood(food);
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
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
}

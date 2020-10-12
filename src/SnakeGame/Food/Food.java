package SnakeGame.Food;

import SnakeGame.Entity;
import SnakeGame.Map;
import SnakeGame.ObjectRendered;

public abstract class Food extends Entity implements ObjectRendered {

    public Food(Map map) {
        super(map);
        this.position = setStartingPosition();
    }

    public abstract int getFoodValue();

}

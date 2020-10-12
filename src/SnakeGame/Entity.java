package SnakeGame;

import java.util.Random;

public class Entity {
    protected Position position;
    protected Map map;
    private Random random = new Random();

    public Entity(Map map) {
        this.map = map;
    }

    protected Position getPosition() {
        return position;
    }

    protected Position setPosition(Position position) {
        return this.position = position;
    }

    protected Position setNewPosition() {

        position.setX(random.nextInt(map.height() - 2) + 1);
        position.setY(random.nextInt(map.width() - 2) + 1);

        return position;
    }

    protected Position setStartingPosition() {
        return new Position(random.nextInt(map.height() - 2) + 1, random.nextInt(map.width() - 2) + 1);
    }

}

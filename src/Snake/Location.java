package Snake;

import java.util.Random;

public class Location {
    protected Position position;
    protected Map map;

    Random random = new Random();

    public Location(Map map)
    {
        this.map=map;
    }

    protected Position getPosition() {
        return position;
    }

    protected Position setPosition(Position position)
    {
        return this.position=position;
    }

    protected Position setNewPosition()
    {

        position.setX(random.nextInt(map.height() - 2) + 1);
        position.setY(random.nextInt(map.width() - 2) + 1);

        return position;
    }

    protected Position setStartingPosition()
    {
        return new Position(random.nextInt(map.height() - 2) + 1, random.nextInt(map.width() - 2) + 1);
    }



}

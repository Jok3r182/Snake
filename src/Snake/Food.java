package Snake;

public abstract class Food extends Entity implements FoodValue{

    public Food(Map map) {
        super(map);
        this.position=setStartingPosition();
    }

}

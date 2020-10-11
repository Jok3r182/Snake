package Snake;

import static Snake.GameSettings.appleValue;


public class Apple extends Entity implements FoodValue {

    public Apple(Map map) {
        super(map);
        this.position = setStartingPosition();
    }

    @Override
    public int getFoodValue() {
        return appleValue;
    }

}

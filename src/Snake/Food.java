package Snake;

import static Snake.GameSettings.foodValue;

public class Food extends Location{

    public Food(Map map) {
        super(map);
        this.position = setStartingPosition();
    }

    public int getFoodValue() {
        return foodValue;
    }

}

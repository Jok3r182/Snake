package Snake;

import static Snake.GameSettings.goldenAppleValue;

public class GoldenApple extends Entity implements FoodValue {

    public GoldenApple(Map map) {
        super(map);
    }

    @Override
    public int getFoodValue() {
        return goldenAppleValue;
    }
}

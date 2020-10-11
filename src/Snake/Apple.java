package Snake;

import static Snake.GameSettings.appleValue;


public class Apple extends Food{

    public Apple(Map map) {
        super(map);
    }

    @Override
    public int getFoodValue() {
        return appleValue;
    }
}

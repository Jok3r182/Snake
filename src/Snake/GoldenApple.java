package Snake;

import static Snake.GameSettings.goldenAppleValue;

public class GoldenApple extends Food {

    public GoldenApple(Map map) {
        super(map);
    }

    @Override
    public int getFoodValue() {
        return goldenAppleValue;
    }
}

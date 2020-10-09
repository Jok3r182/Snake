package Snake;

public class Food {
    private Position position;
    private int value=10;

    public Food(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

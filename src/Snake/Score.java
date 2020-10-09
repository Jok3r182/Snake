package Snake;

public class Score {
    private Food food;
    private int score;

    public Score(Food food) {
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int scored()
    {
        return score=score+food.getValue();
    }

    public int getScore() {
        return this.score;
    }
}

package Snake;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Score {
    private Food food;
    private int score;
    private int highScore;

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

    public int getHighScore()
    {
        Scanner s=null;
        String firstLine=null;
        try {
            s = new Scanner(new File("src/HighScore/highScore.txt"));
            String gamintojas = null;
            while (s.hasNext()) {
                firstLine = s.nextLine();
            }
        } catch (Exception klaida) {
            System.out.println("Error");
            klaida.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
        highScore= Integer.parseInt(firstLine);
        return highScore;
    }

    public void saveHighScore()
    {
        FileWriter fos = null;
        try {
            fos = new FileWriter("src/HighScore/highScore.txt");
            if (score>highScore)
            {
                fos.write(Integer.toString(score));
            }
            else {
                fos.write(Integer.toString(highScore));
            }

        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }
}

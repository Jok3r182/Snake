package Snake;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Score {
    private Apple apple;
    private int score;
    private int highScore;

    public Score(Apple apple) {
        this.apple = apple;
    }

    public int scored() {
        return score = score + apple.getFoodValue();
    }

    public int getScore() {
        return this.score;
    }

    public int getHighScore() {
        Scanner s = null;
        String firstLine = null;
        try {
            s = new Scanner(new File("src/HighScore/highScore.txt"));
            while (s.hasNext()) {
                firstLine = s.nextLine();
            }
        } catch (Exception error) {
            System.err.println("Error");
            error.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
        highScore = Integer.parseInt(firstLine);
        return highScore;
    }

    public void saveHighScore() {
        FileWriter fos = null;
        try {
            fos = new FileWriter("src/HighScore/highScore.txt");
            if (score > highScore) {
                fos.write(Integer.toString(score));
            } else {
                fos.write(Integer.toString(highScore));
            }

        } catch (Exception e) {
            System.err.println("Error");
        } finally {
            try {
                fos.close();
            } catch (Exception e) {
            }
        }
    }
}

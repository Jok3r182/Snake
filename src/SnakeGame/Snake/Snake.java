package SnakeGame.Snake;

import SnakeGame.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static SnakeGame.GameSettings.*;

public class Snake extends Entity implements ObjectRendered {
    private ArrayList<Position> positions = new ArrayList<>();

    public Snake(Map map) {
        super(map);
        this.position = setStartingPosition();
    }

    public void addTail(Position position) {
        positions.add(position);
    }

    public List<Position> getTailPositions() {
        return positions;
    }

    public void snakeTailMovement() {

        Position position = new Position(this.position);
        for (int i = 0; i < getTailPositions().size(); i++) {
            Position temporaryPos = new Position(getTailPositions().get(i));
            getTailPositions().get(i).setY(position.getY());
            getTailPositions().get(i).setX(position.getX());
            position.setY(temporaryPos.getY());
            position.setX(temporaryPos.getX());
        }

    }

    public Position positionUp()
    {
      return getPosition().up();
    }

    public Position positionLeft() {
        return getPosition().left();
    }

    public Position positionRight()
    {
        return getPosition().right();
    }

    public Position positionDown()
    {
        return getPosition().down();
    }

    @Override
    public void renderObject(Graphics graphics, Level level) throws IOException {
        BufferedImage snakeImg = ImageIO.read(new FileInputStream("src/img/snakeSpriteNr2.png"));
        BufferedImage tailImg = ImageIO.read(new FileInputStream("src/img/tailSnake.png"));

        if (!getTailPositions().isEmpty()) {
            for (Position pos : getTailPositions()) {
                graphics.drawImage(tailImg, distanceBetweenHeadingX + pos.getX() * hitboxSize, distanceBetweenHeadingY + pos.getY() * hitboxSize, snakeImgX, snakeImgY, null);
            }

        }
        graphics.drawImage(snakeImg, distanceBetweenHeadingX + getPosition().getX() * hitboxSize, distanceBetweenHeadingY + getPosition().getY() * hitboxSize, snakeImgX, snakeImgY, null);
    }
}

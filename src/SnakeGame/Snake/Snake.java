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

        Position pos = new Position(this.position); //paimame galvos poziciją
        for (int i = 0; i < getTailPositions().size(); i++) {
            Position tpos = new Position(getTailPositions().get(i)); //temp prisiliginame esamai uodegos pos
            getTailPositions().get(i).setY(pos.getY());//pirmaja pos keičiame headpos
            getTailPositions().get(i).setX(pos.getX());
            pos.setY(tpos.getY());//patį headpos keičiame tpos
            pos.setX(tpos.getX());
            /*pvz headpos 0 4 0 3 0 2
            tuomet tpos-0 3, 0 3 keisime (pos) 0 4, o pos keisime į tpos į 0 3
            kai prieisime 0 2, juos keisime į pos kas buvo 0 3, o 0 3 į 0 2, taip eitume kol praeitume visą listą
            0 3 0 3 suvalgius
            paėjus 0 4 0 3
            tuomet suvalgius būtų 0 4 0 3 0 4
            paėjus 0 5 0 4 0 3*/
        }

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

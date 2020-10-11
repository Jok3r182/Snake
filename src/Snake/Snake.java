package Snake;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class Snake extends Location{
    private ArrayList<Position> positions= new ArrayList<>();

    public Snake(Map map) {
        super(map);
        this.position=setStartingPosition();
    }

    public void addPositions(Position position)
    {
        positions.add(position);
    }

    public List<Position> getPositions()
    {
     return positions;
    }

    public void snakeUnitMovement()
    {

        Position pos =new Position(this.position); //paimame galvos poziciją
        for (int i=0; i<getPositions().size(); i++)
        {
            Position tpos = new Position(getPositions().get(i)); //temp prisiliginame esamai uodegos pos
            getPositions().get(i).setY(pos.getY());//pirmaja pos keičiame headpos
            getPositions().get(i).setX(pos.getX());
            pos.setY(tpos.getY());//patį headpos keičiame tpos
            pos.setX(tpos.getX());
         //pvz headpos 0 4 0 3 0 2
            //tuomet tpos-0 3, 0 3 keisime (pos) 0 4, o pos keisime į tpos į 0 3
            //kai prieisime 0 2, juos keisime į pos kas buvo 0 3, o 0 3 į 0 2, taip eitume kol praeitume visą listą
            //0 3 0 3 suvalgius
            //paėjus 0 4 0 3
            //tuomet suvalgius būtų 0 4 0 3 0 4
            //paėjus 0 5 0 4 0 3
        }

    }

}

package world;
import java.util.LinkedList;

import static world.Parameters.*;

public class Person {
    public int id;
    public int startLine;
    public Direction currentDirection;
    public LinkedList<Direction> directions;

    public Person(Station stationStart,int startLine, LinkedList directionList) {
        this.id = stationStart.id;
        this.startLine = startLine;
        this.directions = directionList;
        this.goToNextDir();

    }

    public void addDirection(Direction dir){
        directions.add(dir);
    }

    public void goToNextDir(){
        if(!directions.isEmpty()){
            this.currentDirection = directions.pop();
        }

    }

}

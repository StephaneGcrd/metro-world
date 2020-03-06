package world;
import java.util.LinkedList;

import static world.Parameters.*;

public class Person {
    public int id;
    public int startLine;
    public Direction currentDirection;
    public LinkedList<Direction> directions;

    public Person(int stationStartId,int startLine, LinkedList directionList) {
        this.id = stationStartId;
        this.startLine = startLine;
        this.directions = directionList;
        this.goToNextDir();

    }

    public void addDirection(Direction dir){
        // If there is no currentDirection set, then add it to it in priority before the queue.
        if(currentDirection == null){
            currentDirection = dir;
        }else{
            directions.add(dir);
        }

    }

    public void goToNextDir(){
        if(!directions.isEmpty()){
            this.currentDirection = directions.pop();
        }

    }

}

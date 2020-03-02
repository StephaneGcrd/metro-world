package world;
import static world.Parameters.*;

public class Person {
    public int id;
    public Direction direction;


    public class Direction {
        public int destinationId;
        public trainDirection destinationDirection;

        public Direction(int destinationId, trainDirection destinationDirection) {
            this.destinationId = destinationId;
            this.destinationDirection = destinationDirection;
        }
    }

    public Person(Station stationStart, int destinationId, trainDirection destinationDirection) {
        this.id = stationStart.id;

        this.direction = new Direction(destinationId, destinationDirection);
        stationStart.addPerson(this);
    }

}

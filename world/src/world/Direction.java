package world;

public class Direction {

    public int destinationId;
    public int destinationLine;
    public Parameters.trainDirection destinationDirection;

    public Direction(int destinationId, int destinationLine, Parameters.trainDirection destinationDirection) {
        this.destinationId = destinationId;
        this.destinationDirection = destinationDirection;
        this.destinationLine = destinationLine;
    }
}
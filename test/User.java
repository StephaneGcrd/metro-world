import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import world.Direction;
import world.Parameters;
import world.Person;

import java.util.LinkedList;

public class User {

    @Test
    public void createDirection(){
        Direction dir = new Direction(6,1, Parameters.trainDirection.FORWARD);
        Assert.assertEquals(dir.destinationId,6);
        Assert.assertEquals(dir.destinationLine,1);
        Assert.assertEquals(dir.destinationDirection, Parameters.trainDirection.FORWARD);
    }

    @Test
    public void createDirectionList(){
        LinkedList<Direction> directions =  new LinkedList<Direction>();
        directions.add(new Direction(6,1, Parameters.trainDirection.FORWARD));
        directions.add(new Direction(2,1,Parameters.trainDirection.BACKWARD));
        Direction dir = directions.pop();
        Assert.assertEquals(dir.destinationId,6);
        Assert.assertEquals(dir.destinationLine,1);
        Assert.assertEquals(dir.destinationDirection, Parameters.trainDirection.FORWARD);
    }

    @Test
    public void createPerson(){
        LinkedList<Direction> directions =  new LinkedList<Direction>();
        Person person = new Person(1,1, directions);
        Assert.assertEquals(person.startLine, 1);
        Assert.assertEquals(person.id, 1);
    }

    @Test
    public void createPersonWithDirectionsAndCheckIfUpdate(){
        LinkedList<Direction> directions =  new LinkedList<Direction>();
        directions.add(new Direction(6,1, Parameters.trainDirection.FORWARD));
        directions.add(new Direction(2,1,Parameters.trainDirection.BACKWARD));
        Person person = new Person(1,1, directions);

        Direction dir = person.currentDirection;
        Assert.assertEquals(dir.destinationId,6);
        Assert.assertEquals(dir.destinationLine,1);
        Assert.assertEquals(dir.destinationDirection, Parameters.trainDirection.FORWARD);
    }

    @Test
    public void createPersonWithDirections(){
        LinkedList<Direction> directions =  new LinkedList<Direction>();
        directions.add(new Direction(6,1, Parameters.trainDirection.FORWARD));
        directions.add(new Direction(2,1,Parameters.trainDirection.BACKWARD));
        Person person = new Person(1,1, directions);
        Direction dir = person.directions.pop();
        Assert.assertEquals(dir.destinationId,2);
        Assert.assertEquals(dir.destinationLine,1);
        Assert.assertEquals(dir.destinationDirection, Parameters.trainDirection.BACKWARD);
    }

    @Test
    public void addDirectionOnPersonWithEmptyLL(){
        LinkedList<Direction> directions =  new LinkedList<Direction>();
        //directions.add(new Direction(6,1, Parameters.trainDirection.FORWARD));
        //directions.add(new Direction(2,1,Parameters.trainDirection.BACKWARD));

        Person person = new Person(1,1, directions);
        person.addDirection(new Direction(6,1, Parameters.trainDirection.FORWARD));
        Direction dir = person.currentDirection;
        Assert.assertEquals(dir.destinationId,6);
        Assert.assertEquals(dir.destinationLine,1);
        Assert.assertEquals(dir.destinationDirection, Parameters.trainDirection.FORWARD);
    }

    @Test
    public void addDirectionOnPerson(){
        LinkedList<Direction> directions =  new LinkedList<Direction>();
        directions.add(new Direction(6,1, Parameters.trainDirection.FORWARD));

        Person person = new Person(1,1, directions);
        person.addDirection(new Direction(2,1, Parameters.trainDirection.BACKWARD));
        Direction dir = person.directions.pop();
        Assert.assertEquals(dir.destinationId,2);
        Assert.assertEquals(dir.destinationLine,1);
        Assert.assertEquals(dir.destinationDirection, Parameters.trainDirection.BACKWARD);
    }



}

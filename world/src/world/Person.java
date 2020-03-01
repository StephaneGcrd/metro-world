package world;

public class Person {
    public int id;
    public int destinationId;
    public boolean done = false;

    public Person(Station stationStart, int destinationId) {
        this.id = stationStart.id;
        this.destinationId = destinationId;
        stationStart.addPerson(this);
    }

}

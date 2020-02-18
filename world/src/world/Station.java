package world;

public class Station {
    private String name;
    private int capacity;

    public Station(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "[" + name  + "]";
    }
}

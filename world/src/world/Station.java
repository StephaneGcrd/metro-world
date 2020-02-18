package world;

public class Station {
    private String name;
    private int capacity;
    private int posX;
    private int posY;

    public Station(String name, int capacity, int x, int y) {
        this.name = name;
        this.capacity = capacity;
        this.posX = x;
        this.posY = y;
    }

    @Override
    public String toString() {
        return "[" + name  + "]";
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

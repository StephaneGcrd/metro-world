package world;

import java.util.ArrayList;

public class Station {
    private String name;
    public int id;
    private int capacity;
    private int posX;
    private int posY;


    public Station(String name,int id, int capacity, int x, int y) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.posX = x;
        this.posY = y;
    }

    @Override
    public String toString() {
        return "[" +id +","+ name +"]";
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


}

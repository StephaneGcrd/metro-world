package world;

import world.util.StationPeopleList;

import java.util.LinkedList;

public class Station {
    private String name;
    public int id;
    private int capacity;
    private int posX;
    private int posY;


    public StationPeopleList stationPeopleList = new StationPeopleList();



    public Station(String name,int id, int capacity, int x, int y) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.posX = x;
        this.posY = y;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "[" +id +","+ name +"]";
    }

    public int getNbPersons(int lineId){
        return stationPeopleList.getPlatformSize(lineId);
    }

    public void add(Person person){
        stationPeopleList.add(person,person.currentDirection.destinationLine);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


}

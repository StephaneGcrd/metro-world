package world;

import java.util.LinkedList;

public class Station {
    private String name;
    public int id;
    private int capacity;
    private int posX;
    private int posY;
    public LinkedList<Person> personListForward;
    public LinkedList<Person> personListBackward;



    public Station(String name,int id, int capacity, int x, int y) {
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.posX = x;
        this.posY = y;
        this.personListForward = new LinkedList<>();
        this.personListBackward = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "[" +id +","+ name +"]";
    }

    public int getNbPersons(){
        return personListForward.size()+personListBackward.size();
    }

    public void addPerson(Person person){
        if (person.direction.destinationDirection == Parameters.trainDirection.FORWARD){
            personListForward.add(person);
        }
        else{
            personListBackward.add(person);
        }

    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }


}

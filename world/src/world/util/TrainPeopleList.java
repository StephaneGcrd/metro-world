package world.util;

import world.Person;
import world.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TrainPeopleList {
    private int maxSize;
    private int nbPeople = 0;

    public HashMap<Integer, ArrayList> personMap = new HashMap<>();

    public TrainPeopleList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(Person person){
        if(nbPeople< maxSize){
            if(this.personMap.containsKey(person.currentDirection.destinationId)){
                ArrayList<Person> list = this.personMap.get(person.currentDirection.destinationId);
                list.add(person);
            }else{
                ArrayList<Person> PersonList = new ArrayList<>();
                PersonList.add(person);

                this.personMap.put(person.currentDirection.destinationId, PersonList);
            }
        }
        nbPeople++;
    }

    public ArrayList<Person> getAndRemove(int stId){
        ArrayList<Person> pplToReturn = new ArrayList<>();
        if(this.personMap.containsKey(stId)){
            ArrayList<Person> list = this.personMap.get(stId);
            for(Person personElement: list){

                pplToReturn.add(personElement);
                personElement.goToNextDir();
                nbPeople--;
            }

            list.clear();
            this.personMap.remove(stId);
        }

        return  pplToReturn;
    }

    public int size(){
        return nbPeople;
    }

    public boolean spaceIsAvailable(){
        if(nbPeople < maxSize){
            return true;
        }
        return false;
    }
}

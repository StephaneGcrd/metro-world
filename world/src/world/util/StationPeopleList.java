package world.util;

import world.Parameters;
import world.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class StationPeopleList {
    public HashMap<Integer, Platform> personMap = new HashMap<>();


    public class Platform{
        public LinkedList<Person> personListForward = new LinkedList<>();
        public LinkedList<Person> personListBackward = new LinkedList<>();

        public void add(Person person){
            if (person.currentDirection.destinationDirection == Parameters.trainDirection.FORWARD){
                personListForward.add(person);
            }
            else{
                personListBackward.add(person);
            }
        }

        public Person pop(Parameters.trainDirection direction){
            if (direction == Parameters.trainDirection.FORWARD){
                return personListForward.pop();
            }else{
                return personListBackward.pop();
            }
        }

        public int getSize(){
            return personListBackward.size()+personListForward.size();
        }
    }
    public int getPlatformSize(int lineId){
        return personMap.get(lineId).getSize();
    }

    public void addLine(int lineNb){
        // Done at line initialization
        if(!this.personMap.containsKey(lineNb)){
            this.personMap.put(lineNb, new Platform());
        }else{
            System.out.println("Line already added here");
        }
    }

    public Person pop(int lineNb, Parameters.trainDirection direction){
        Platform platform = this.personMap.get(lineNb);
        return platform.pop(direction);
    }

    public boolean isForwardEmpty(int lineNb){
        Platform platform = this.personMap.get(lineNb);
        return platform.personListForward.isEmpty();
    }

    public boolean isBackwardEmpty(int lineNb){
        Platform platform = this.personMap.get(lineNb);
        return platform.personListBackward.isEmpty();
    }

    public void add(Person person,int lineNumber){
        if(this.personMap.containsKey(lineNumber)){
            Platform platform = this.personMap.get(lineNumber);
            platform.add(person);
        }
        else{
            System.out.println("Error : Line "+lineNumber+" doesnt exist in this stationPeopleList");
        }
    }

}

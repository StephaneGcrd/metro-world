package world;

import world.util.TrainPeopleList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Train {
    public int id;
    public int loc_id;
    ListIterator iterator;
    public boolean forward = true;
//    public ArrayList<Person> passengers =  new ArrayList<Person>();
    public TrainPeopleList passengers = new TrainPeopleList(2);

    public Train(int id, LinkedList<Station> stationQueue) {
        this.id = id;
        iterator = stationQueue.listIterator();
        Station st = (Station) iterator.next();
        this.loc_id = st.id;
    }

    public void goToNext(){
        Station st = null;

        if(forward){
            st = (Station) iterator.next();
        }

        if(!forward){
            st = (Station) iterator.previous();
        }

        loc_id = st.id;
        checkForPassengers(st);

        if(!iterator.hasNext()){
            forward = false;
            iterator.previous();
        }
        if(!iterator.hasPrevious()){
            forward = true;
            iterator.next();
        }

    }

    public void checkForPassengers(Station st){

        if(forward){
            while(!st.personListForward.isEmpty() && passengers.spaceIsAvailable()){
                Person person = st.personListForward.pop();
                passengers.add(person);
            }
        }else{
            while(!st.personListBackward.isEmpty()  && passengers.spaceIsAvailable()){
                Person person = st.personListBackward.pop();
                passengers.add(person);
            }
        }

        ArrayList<Person> psgToDrop =  passengers.getAndRemove(st.id);

        for (Person person: psgToDrop){
            if(person.direction.destinationDirection == Parameters.trainDirection.FORWARD){
                    st.personListForward.add(person);
            }else{
                st.personListBackward.add(person);
            }
        }



    }


    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", loc_id=" + loc_id +
                '}';
    }
}

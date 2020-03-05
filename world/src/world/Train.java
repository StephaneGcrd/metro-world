package world;

import world.util.TrainPeopleList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Train {
    public int id;
    public int loc_id;
    public int lineId;
    ListIterator iterator;
    public boolean forward = true;
//    public ArrayList<Person> passengers =  new ArrayList<Person>();
    public TrainPeopleList passengers = new TrainPeopleList(2);

    public Train(int id, LinkedList<Station> stationQueue, int lineId) {
        this.id = id;
        iterator = stationQueue.listIterator();
        Station st = (Station) iterator.next();
        this.loc_id = st.id;
        this.lineId = lineId;
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
            while(passengers.spaceIsAvailable() && !st.stationPeopleList.isForwardEmpty(this.lineId)){
                Person person = st.stationPeopleList.pop(this.lineId, Parameters.trainDirection.FORWARD);
                passengers.add(person);
            }
        }else{
            while(passengers.spaceIsAvailable() && !st.stationPeopleList.isBackwardEmpty(this.lineId)){
                Person person = st.stationPeopleList.pop(this.lineId, Parameters.trainDirection.BACKWARD);
                passengers.add(person);
            }
        }

        ArrayList<Person> psgToDrop =  passengers.getAndRemove(st.id);

        for (Person person: psgToDrop){
            st.stationPeopleList.add(person, this.lineId);
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

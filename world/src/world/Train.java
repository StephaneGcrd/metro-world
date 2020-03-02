package world;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Train {
    public int id;
    public int loc_id;
    public int capacity = 1;
    public int nb_pp;
    ListIterator iterator;
    public boolean forward = true;
    public ArrayList<Person> passengers =  new ArrayList<Person>();

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
            while(!st.personListForward.isEmpty()  && passengers.size() < capacity ){
                Person person = st.personListForward.pop();
                passengers.add(person);
            }
        }else{
            while(!st.personListBackward.isEmpty()  && passengers.size() < capacity ){
                Person person = st.personListBackward.pop();
                passengers.add(person);
            }
        }







        for(int i = passengers.size() -1; i >=0  ;i--){

            if(passengers.get(i).direction.destinationId == st.id){
                //st.addPerson(person);
                System.out.println("Passenger succesfully went from station "+passengers.get(i).id+" to station "+passengers.get(i).direction.destinationId);

                passengers.remove(i);
                //passengers.remove(person);

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

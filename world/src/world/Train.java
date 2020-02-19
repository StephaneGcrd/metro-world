package world;

import java.util.LinkedList;
import java.util.ListIterator;


public class Train {
    public int id;
    public int loc_id;
    public int capacity;
    public int nb_pp;
    ListIterator iterator;
    public boolean forward = true;

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

        if(!iterator.hasNext()){
            forward = false;
            iterator.previous();
        }
        if(!iterator.hasPrevious()){
            forward = true;
            iterator.next();
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

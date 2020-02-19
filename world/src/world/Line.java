package world;

import java.util.*;

public class Line {

    private int id;
    public LinkedList<Station> stationList; // Queue to prioritize expand when building the flood-fill
    public HashMap<Integer, Station> stationMap = new HashMap<>();
    public ArrayList<Train> trainList =  new ArrayList<Train>();

    public Line(int id) {
        this.id = id;
        this.stationList = new LinkedList<>();
    }

    public void addStation(Station station){
        stationList.add(station);
        stationMap.put(station.id,station);
    }

    public void moveTrains(){
        for(Train train: trainList) {

        }
    }

    public void addTrain(Train train){
        if(stationMap.containsKey(train.loc_id)) {
            trainList.add(train);
        }else{
            System.out.println("Couldn't add train because station not in line "+id);
        }

    }

    /*public void test(){
        Station testSt =stationList.element();
        int id = testSt.id;

        Station st2 = stationMap.get(id);

        System.out.println("S1 :" + testSt);
        System.out.println("S2 :" + st2);

        testSt.id = 6;

        System.out.println("S1 :" + testSt);
        System.out.println("S2 :" + st2);

    }*/

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", stationList=" + stationList +
                '}';
    }
}

package world;

import java.awt.*;
import java.util.*;

public class Line {

    public int id;
    public LinkedList<Station> stationList;
    public HashMap<Integer, Station> stationMap = new HashMap<>();
    public ArrayList<Train> trainList =  new ArrayList<Train>();
    public Color lineColor;

    public Line(int id, Color color) {
        this.id = id;
        this.stationList = new LinkedList<>();
        this.lineColor = color;
    }

    public void addStation(Station station){
        stationList.add(station);
        stationMap.put(station.id,station);
        station.stationPeopleList.addLine(this.id);
    }

    public void moveLineTrains(){
        for(Train train: trainList) {
            train.goToNext();
        }
    }

    public void addTrain(Train train, int offset){
        if(stationMap.containsKey(train.loc_id)) {
            trainList.add(train);
            for(int i = 0; i<offset; i++){
                train.goToNext();
            }
        }else{
            System.out.println("Couldn't add train because station not in line "+id);
        }

    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", stationList=" + stationList +
                '}';
    }
}

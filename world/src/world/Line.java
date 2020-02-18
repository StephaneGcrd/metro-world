package world;

import java.util.LinkedList;
import java.util.Queue;

public class Line {

    private int id;
    private Queue<Station> stationList; // Queue to prioritize expand when building the flood-fill

    public Line(int id) {
        this.id = id;
        this.stationList = new LinkedList<>();
    }

    public void addStation(Station station){
        stationList.add(station);
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", stationList=" + stationList +
                '}';
    }
}

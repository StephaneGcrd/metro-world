package world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class City {
    private int width;
    private int height;
    private String name;
    public HashMap<Integer, Station> stationMap = new HashMap<>();
    public ArrayList<Line> lineList =  new ArrayList<Line>();


    public City(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public void addLine(Line line){
        this.lineList.add(line);

        for(Station station: line.stationList) {
            addStation(station);
        }
    }

    public Station getStation(int id){
        return stationMap.get(id);
    }

    public void addStation(Station station){
        this.stationMap.put(station.id,station);
    }

    public void moveCityTrains(){
        for(Line line: lineList) {
            line.moveLineTrains();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getName(){
        return name;
    }
}

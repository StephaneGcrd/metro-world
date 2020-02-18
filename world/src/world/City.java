package world;

import java.util.ArrayList;
import java.util.HashSet;

public class City {
    private int width;
    private int height;
    private String name;
    private ArrayList<Station> cityStationList =  new ArrayList<Station>();;
    private ArrayList<Line> lineList;
    public HashSet<String> stationsLoc;

    public City(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
        stationsLoc = new HashSet<>();
    }

    public void addLine(Line line){
        lineList.add(line);
    }

    public void addStation(Station station){
        this.cityStationList.add(station);
        stationsLoc.add(station.getPosX()*10+"-"+station.getPosY()*10);
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

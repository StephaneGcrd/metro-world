package world;

import java.util.ArrayList;
import java.util.HashSet;

public class City {
    private int width;
    private int height;
    private String name;
    private ArrayList<Station> cityStationList =  new ArrayList<Station>();;
    public ArrayList<Line> lineList =  new ArrayList<Line>();


    public City(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public void addLine(Line line){
        this.lineList.add(line);
    }

    public void addStation(Station station){
        this.cityStationList.add(station);
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

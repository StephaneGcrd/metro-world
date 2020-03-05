package world;


import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.TimerTask;

public class Simulation extends TimerTask {

    private City city;
    private SimuCanvas canvas;

    public Simulation(City city, SimuCanvas canvas) {
        this.city = city;
        this.canvas = canvas;
    }

    public static int i = 0;
    public void run()
    {
        canvas.repaint();
        city.moveCityTrains();
        i++;

        if(i==3){
            LinkedList<Direction> directions =  new LinkedList<Direction>();
            directions.add(new Direction(6,1,Parameters.trainDirection.FORWARD));
            directions.add(new Direction(2,1,Parameters.trainDirection.BACKWARD));

            city.getStation(2).add(new Person(city.getStation(2),1, directions));

        }

    }
}

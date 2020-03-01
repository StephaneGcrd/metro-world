package world;


import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Simulation extends TimerTask {
    private Train train;
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
            Person boris = new Person(city.getStation(2),5);
            Person boris2 = new Person(city.getStation(2),7);
        }

    }
}

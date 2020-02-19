package world;


import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;

public class Simulation extends TimerTask {
    private Train train;
    private City city;
    private SimuCanvas canvas;

    public Simulation(Train train, SimuCanvas canvas) {
        this.train = train;
        this.canvas = canvas;
    }

    public static int i = 0;
    public void run()
    {
        System.out.println(train.loc_id);
        canvas.repaint();
        train.goToNext();

    }
}

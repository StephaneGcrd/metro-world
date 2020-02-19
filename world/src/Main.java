import world.*;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to metro world!");

        City paris = new City(50,50,"Paris");
        Line ligne1 = new Line(1);
        Line ligne2 = new Line(2);

        Station reuilly = new Station("Reuilly-diderot",1, 10, 40, 25);
        ligne1.addStation(reuilly);
        ligne1.addStation(new Station("Chatelet",2, 10, 25,20));
        ligne1.addStation(new Station("Montparnasse",3, 10, 10,35));

        ligne2.addStation(new Station("Copenhagen", 4, 10, 25, 10 ));
        ligne2.addStation(reuilly);
        ligne2.addStation(new Station("South", 5, 10, 25, 40 ));

        paris.addLine(ligne1);
        paris.addLine(ligne2);
        Train train = new Train(1,ligne1.stationList);
        Train train2 = new Train(1,ligne2.stationList);
        ligne1.addTrain(train);
        ligne1.addTrain(train2);



        JFrame frame = new JFrame(paris.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(paris.getWidth()*10,paris.getHeight()*10);

        Timer timer = new Timer();
        SimuCanvas canvas = new SimuCanvas(paris);
        TimerTask task = new Simulation(train, canvas);

        frame.getContentPane().add(canvas);
        timer.schedule(task, 2000, 1000);
        frame.setVisible(true);


    }
}
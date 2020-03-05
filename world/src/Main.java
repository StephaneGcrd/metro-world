import world.*;
import world.util.IdGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends IdGenerator {


    public static void main(String[] args) {
        System.out.println("Welcome to metro world!");

        City paris = new City(100,100,"Paris");
        Line ligne1 = new Line(createLineId(), Color.YELLOW);
        Line ligne2 = new Line(createLineId(), Color.RED);



        ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,10));
        ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,20));
        Station stationSwitch =new Station(getCurrentStringStationId(),createStationId(), 10, 50,30);
        ligne1.addStation(stationSwitch);
        ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,40));
        ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,50));
        ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,60));
        ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,70));
        ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,80));
        //ligne1.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 50,90));


        ligne2.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 10,10));
        ligne2.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 20,10));
        ligne2.addStation(stationSwitch);
        ligne2.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 60,40));
        ligne2.addStation(new Station(getCurrentStringStationId(),createStationId(), 10, 80,40));




        paris.addLine(ligne1);
        //paris.addLine(ligne2);

        Train train = new Train(1,ligne1.stationList, ligne1.id);
        //Train train2 = new Train(2,ligne2.stationList, ligne2.id);
        //Train train2 = new Train(2,ligne1.stationList);
        ligne1.addTrain(train,0);
        //ligne2.addTrain(train2,0);
        //ligne1.addTrain(train2,5);

        System.out.println(paris.stationMap.get(1));
        JFrame frame = new JFrame(paris.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(paris.getWidth()*10,paris.getHeight()*10);

        Timer timer = new Timer();
        SimuCanvas canvas = new SimuCanvas(paris);
        TimerTask task = new Simulation(paris, canvas);

        frame.getContentPane().add(canvas);
        timer.schedule(task, 200, 400);
        frame.setVisible(true);


    }
}
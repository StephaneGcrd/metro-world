import world.*;
import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static int stationId = 0;
    private static int lineId = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to metro world!");

        City paris = new City(100,100,"Paris");
        Line ligne1 = new Line(lineId++, Color.YELLOW);
        Line ligne2 = new Line(lineId++, Color.RED);

        for(int id =0; id<10; id++){
            ligne1.addStation(new Station(""+id,stationId++, 10, id*10,id*10));
        }


        paris.addLine(ligne1);

        Train train = new Train(1,ligne1.stationList);
        Train train2 = new Train(2,ligne1.stationList);
        ligne1.addTrain(train,0);
        //ligne1.addTrain(train2,5);


        JFrame frame = new JFrame(paris.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(paris.getWidth()*10,paris.getHeight()*10);

        Timer timer = new Timer();
        SimuCanvas canvas = new SimuCanvas(paris);
        TimerTask task = new Simulation(paris, canvas);

        frame.getContentPane().add(canvas);
        timer.schedule(task, 200, 200);
        frame.setVisible(true);


    }
}
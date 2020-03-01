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





//        ligne2.addStation(new Station("South33", 688, 10, 20, 5 ));
//        ligne2.addStation(new Station("Copenhagen", 4, 10, 25, 10 ));
//        ligne2.addStation(reuilly);
//        ligne2.addStation(new Station("South", 5, 10, 25, 40 ));
//        ligne2.addStation(new Station("South", 66, 10, 40, 40 ));

        paris.addLine(ligne1);

        Train train = new Train(1,ligne1.stationList);
        Train train2 = new Train(2,ligne1.stationList);
        //Train train2 = new Train(5,ligne2.stationList);
        ligne1.addTrain(train,0);
        ligne1.addTrain(train2,5);
        //ligne2.addTrain(train2);



        JFrame frame = new JFrame(paris.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(paris.getWidth()*10,paris.getHeight()*10);

        Timer timer = new Timer();
        SimuCanvas canvas = new SimuCanvas(paris);
        TimerTask task = new Simulation(paris, canvas);

        frame.getContentPane().add(canvas);
        timer.schedule(task, 200, 800);
        frame.setVisible(true);


    }
}
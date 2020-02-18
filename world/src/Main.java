import world.*;
import javax.swing.*;
import java.awt.*;

class MyCanvas extends JComponent
{
    private int width;
    private int height;
    private City city;

    public MyCanvas(City city) {
        this.city = city;
        this.width = city.getWidth();
        this.height = city.getHeight();
    }

    public void paint(Graphics g)
    {
        paintGrid(g);
    }

    public void paintGrid(Graphics g){
        System.out.println(city.stationsLoc);

        for ( int i = 0; i < width*10; i+=10){
            for ( int j = 0;j < height*10;j+=10){

                if(!city.stationsLoc.contains(i+"-"+j)){
                    g.drawRect (i, j, 10, 10);
                }else{
                    g.fillRect (i, j, 10, 10);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to metro world!");

        City paris = new City(50,50,"Paris");
        /*Line ligne1 = new Line(1);
        ligne1.addStation(new Station("Reuilly-diderot", 10));
        ligne1.addStation(new Station("Chatelet", 40));*/
        //System.out.println(ligne1.toString());
        paris.addStation(new Station("Reuilly-diderot", 10, 40, 25));
        paris.addStation(new Station("Chatelet", 10, 25,20));
        paris.addStation(new Station("Montparnasse", 10, 10,35));

        JFrame frame = new JFrame(paris.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(paris.getWidth()*10,paris.getHeight()*10);

        frame.getContentPane().add(new MyCanvas(paris));
        frame.setVisible(true);
    }
}
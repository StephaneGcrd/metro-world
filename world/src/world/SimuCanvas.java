package world;

import javax.swing.*;
import java.awt.*;

public class SimuCanvas extends JComponent
    {
        private int width;
        private int height;
        private City city;

        public SimuCanvas(City city) {
            this.city = city;
            this.width = city.getWidth();
            this.height = city.getHeight();
        }

        public void paint(Graphics g)
        {
            paintGrid(g);
        }

        public void paintGrid(Graphics g){
            //System.out.println(city.stationsLoc);



            for (Line line: city.lineList) {
                int prevX = -1;
                int prevY = -1;
                //g.setStroke(new BasicStroke(2));


                for (Station station: line.stationList) {

                    g.fillRect(station.getPosX()*10, station.getPosY()*10, 10, 10);

                    if (prevX > -1 && prevY > -1){
                        g.drawLine((prevX*10)+5,(prevY*10)+5 , (station.getPosX()*10)+5, (station.getPosY()*10)+5);
                    }

                    prevX = station.getPosX();
                    prevY = station.getPosY();

                }


                for(Train train: line.trainList){
                    Station station = line.stationMap.get(train.loc_id);

                    g.fillRect(station.getPosX()*10, station.getPosY()*10, 10, 10);
                }
            }

            for (Line line: city.lineList) {


                for(Train train: line.trainList){
                    Station station = line.stationMap.get(train.loc_id);
                    g.setColor(Color.RED);
                    g.fillRect(station.getPosX()*10, station.getPosY()*10, 10, 10);
                }

            }


        }
    }


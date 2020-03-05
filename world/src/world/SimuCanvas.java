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
                    //g.drawString("St. n°"+station.id,station.getPosX()*10,(station.getPosY()*10)-20);

                    if(station.getNbPersons(line.id)>0){
                        g.drawString(""+station.getNbPersons(line.id),station.getPosX()*10,station.getPosY()*10-3);
                    }

                    g.fillRect(station.getPosX()*10, station.getPosY()*10, 10, 10);

                    if (prevX > -1 && prevY > -1){
                        g.drawLine((prevX*10)+5,(prevY*10)+5 , (station.getPosX()*10)+5, (station.getPosY()*10)+5);
                    }

                    prevX = station.getPosX();
                    prevY = station.getPosY();

                }



            }

            for (Line line: city.lineList) {


                for(Train train: line.trainList){
                    Station station = line.stationMap.get(train.loc_id);
                    g.setColor(Color.BLUE);
                    if(train.passengers.size()>0){
                        g.drawString(" "+train.passengers.size(),station.getPosX()*10,(station.getPosY()*10)+30);
                    }


                    g.setColor(line.lineColor);
                    if(train.forward){

                        g.fillRect((station.getPosX()*10)+5, station.getPosY()*10, 5, 10);
                    }else{
                        g.fillRect((station.getPosX()*10), station.getPosY()*10, 5, 10);
                    }
                }

            }


        }
    }


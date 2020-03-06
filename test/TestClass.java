
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import world.City;
import world.Line;
import world.Station;
import world.Train;
import world.util.IdGenerator;

import java.awt.*;


public class TestClass extends IdGenerator{

    private City city;

    @BeforeMethod
    public void init() {
        city = new City(100,100,"Paris");;
        resetCounts();
    }

    @Test
    public void testToTest(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void createCityAndCheckName() {
        Assert.assertEquals("Paris", city.getName());
    }

    @Test
    public void createLines() {
        Line ligne1 = new Line(createLineId(), Color.YELLOW);
        Line ligne2 = new Line(createLineId(), Color.RED);
        Assert.assertEquals(ligne1.id, 1);
        Assert.assertEquals(ligne2.id, 2);
    }

    @Test
    public void AddLinesInCity(){
        Line ligne1 = new Line(createLineId(), Color.YELLOW);
        Line ligne2 = new Line(createLineId(), Color.RED);
        city.addLine(ligne1);
        city.addLine(ligne2);
        Assert.assertEquals(city.lineList.get(0).id, 1);
        Assert.assertEquals(city.lineList.get(1).id, 2);
    }

    @Test
    public void AddLinesWithStation(){
        Line ligne1 = new Line(createLineId(), Color.YELLOW);
        ligne1.addStation(new Station("nom",createStationId(), 10, 50,10));
        city.addLine(ligne1);
        Assert.assertEquals(city.getStation(1).id,1);
        Assert.assertEquals(city.getStation(1).getName(),"nom");
    }

    @Test
    public void AddTrainToLine(){
        Line ligne1 = new Line(createLineId(), Color.YELLOW);
        ligne1.addStation(new Station("nom",createStationId(), 10, 50,10));
        city.addLine(ligne1);
        Assert.assertEquals(city.getStation(1).id,1);
        Train train = new Train(1,ligne1.stationList, ligne1.id);
        ligne1.addTrain(train,0);
        Assert.assertEquals(ligne1.trainList.get(0).loc_id, 1);
    }


}
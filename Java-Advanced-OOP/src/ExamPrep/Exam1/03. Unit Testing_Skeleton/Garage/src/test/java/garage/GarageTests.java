package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car honda;
    private Car mercedes;
    private Car kia;
    private final static int EXAMPLE_MAX_SPEED =260;
    @ Before
    public void setup() {
        this.garage = new Garage();


        honda = new Car("Honda", 200, 1000);
        mercedes = new Car("Mercedes", 300, 2000);
        kia = new Car("Kia", 250, 1500);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrowsExceptionIfCarIsNull(){
garage.addCar(null);

}
@Test
    public void testAddCarAddsCarToList() {
        garage.addCar(mercedes);
        Assert.assertEquals(1,garage.getCount());
        garage.addCar(honda);
    Assert.assertEquals(2,garage.getCount());

    garage.addCar(kia);
    Assert.assertEquals(3,garage.getCount());


    }
@Test
public void testGetCarSuccessully(){
garage.addCar(mercedes);
List<Car> carsInGarage = garage.getCars();
Assert.assertEquals(1,garage.getCount());
Assert.assertEquals(mercedes.getBrand(),carsInGarage.get(0).getBrand());
    }
    @Test
    public void TestFindAllCarsWithMaxSpeedAbove(){
garage.addCar(mercedes);
garage.addCar(kia);
garage.addCar(honda);
List<Car> carsWithMaxSpeedAboveValue = garage.findAllCarsWithMaxSpeedAbove(EXAMPLE_MAX_SPEED);
Assert.assertEquals(mercedes.getBrand(),carsWithMaxSpeedAboveValue.get(0).getBrand());

    }

    @Test
    public void TestGetMostExpensiveCar(){
        garage.addCar(mercedes);
        garage.addCar(kia);
        garage.addCar(honda);
        Car mostExpensive = garage.getTheMostExpensiveCar();
        Assert.assertEquals(mercedes.getBrand(),mostExpensive.getBrand());
    }
    @Test
    public  void TestFindCarByBrand(){
        garage.addCar(mercedes);
        garage.addCar(kia);
        garage.addCar(honda);
        List<Car>cars = garage.findAllCarsByBrand(kia.getBrand());
        Assert.assertEquals(1,cars.size());
    }
}
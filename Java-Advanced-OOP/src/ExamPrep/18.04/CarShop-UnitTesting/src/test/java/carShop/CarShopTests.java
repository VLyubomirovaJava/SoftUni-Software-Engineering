package carShop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarShopTests {
    private CarShop carShop;
    private List<Car> cars;

    @Before
    public void setUp() {
        carShop = new CarShop();
        Car car = new Car("Golf", 200, 100);
        Car car2 = new Car("BabyBenz", 250, 100);
      cars = new ArrayList<>();

    }

    @Test
    public void TestGettingCars() {
        carShop.add(new Car("Test", 100, 200));
        Assert.assertEquals(1, carShop.getCars().size());
    }
    @Test
   public void testGetCount() {
        Assert.assertEquals(0, carShop.getCount());
    }

    @Test
    public void TestFindCarWithMaxHP() {
        Car car = new Car("Golf", 200, 100);
        Car car2 = new Car("BabyBenz", 250, 100);
       carShop.add(car);
       carShop.add(car2);
        List<Car> cars = carShop.findAllCarsWithMaxHorsePower(250);
        cars.add(car);
        cars.add(car2);
        Assert.assertNotNull(cars);
        Assert.assertEquals(2, cars.size());
        Assert.assertTrue(cars.stream().allMatch(c -> c.getHorsePower() > 150));

    }

    @Test
   public void testAddNormal() {
        Car newCar = new Car("Porsche",  400, 150000);
        carShop.add(newCar);
        Assert.assertTrue(carShop.getCars().contains(newCar));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        carShop.add(null);
    }
    @Test
    public void testRemove() {
        Car newCar = new Car("Porsche",  400, 150000);
        carShop.add(newCar);
        Car carToRemove = carShop.getCars().get(0);
        Assert.assertTrue(carShop.remove(carToRemove));
        Assert.assertEquals(0, carShop.getCount());
        Assert.assertFalse(carShop.getCars().contains(carToRemove));
    }
    @Test
    public void testGetTheMostLuxuryCar() {
        Car newCar = new Car("Porsche",  400, 150000);
        carShop.add(newCar);
        Car test2 = new Car("Test",  400, 150);
        carShop.add(test2);
        Car test3 = new Car("Test3",  400, 1500);
        carShop.add(test3);
        Car mostLuxuryCar = carShop.getTheMostLuxuryCar();
        Assert.assertEquals("Porsche", mostLuxuryCar.getModel());
    }
    @Test
    public void testFindAllCarByModel() {
        Car newCar = new Car("Porsche",  400, 150000);
        carShop.add(newCar);
        Car test2 = new Car("Test",  400, 150);
        carShop.add(test2);
        Car test3 = new Car("Test3",  400, 1500);
        carShop.add(test3);
        List<Car> cars = carShop.findAllCarByModel("Porsche");
        Assert.assertEquals(1, cars.size());
        Assert.assertEquals("Porsche", cars.get(0).getModel());
    }
}


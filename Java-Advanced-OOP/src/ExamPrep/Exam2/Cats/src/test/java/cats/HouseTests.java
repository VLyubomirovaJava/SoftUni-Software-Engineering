package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class HouseTests {
    private House house;
    private Cat cat;
    private Collection<Cat> cats;

    @Before
    public  void setUp(){
    house = new House("House1",1);
cat = new Cat("Kitty");
cats = new ArrayList<>();
}

    @Test
    public void testGetName() {
        Assert.assertEquals("House1", house.getName());
    }
@Test
public void TestSetNameSetApprop() {
    House house2 = new House("Housey",1);
    Assert.assertEquals("Housey",house2.getName());

}
@Test (expected = NullPointerException.class)
    public void testIfNameIsSetNull() {
    House house3 = new House(null,3);

}
@Test(expected = NullPointerException.class)
    public void testIfNameIsBlank(){
    House house4 = new House("",3);
}
@Test (expected =IllegalArgumentException.class )
    public void testIfCapacityIsNegative(){
    House emptyHouse = new House("negative",-1);


}
@Test
    public void testGetCapacity(){

Assert.assertEquals(1,house.getCapacity());
}

@Test
    public void testAddCat(){
house.addCat(cat);
Assert.assertEquals(1,house.getCapacity());
}
@Test(expected = IllegalArgumentException.class)
  public void  testAddCatWithFullHouse  (){
    Cat cat1 = new Cat("Whiskers");
    Cat cat2 = new Cat("Fluffy");
    Cat cat3 = new Cat("Mittens");
    house.addCat(cat1);
    house.addCat(cat2);
    house.addCat(cat3);

}
@Test
    public void testRemovingCatWithGivenName(){
    Cat cat1 = new Cat("Whiskers");
    house.addCat(cat1);
    house.removeCat("Whiskers");
    Assert.assertEquals(0,house.getCount());

}
    @Test(expected = IllegalArgumentException.class)
    public void TestThrowExceptionIfGivenNameIsNotReal(){
        house.removeCat("Whiskers");

    }
    @Test
    public void testCatForSale() {
        Cat cat = new Cat("Whiskers");
        house.addCat(cat);
        Cat soldCat = house.catForSale("Whiskers");
        Assert.assertFalse(soldCat.isHungry());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testCatForSaleIsNotExisting(){
        house.catForSale("Whiskers");
    }
    @Test
    public void testStatistics(){
        Cat cat1 = new Cat("Whiskers");
        Cat cat2 = new Cat("Fluffy");
        House house = new House("MyHouse",2);
        house.addCat(cat1);
        house.addCat(cat2);
        Assert.assertEquals("The cat Whiskers, Fluffy is in the house MyHouse!", house.statistics());

    }
}


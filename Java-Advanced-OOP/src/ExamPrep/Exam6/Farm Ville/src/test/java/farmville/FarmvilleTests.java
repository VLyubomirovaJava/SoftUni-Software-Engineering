package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class FarmvilleTests {
    private Animal animal1;
    private Farm farm;

@Before
    public void setUp() {
farm = new Farm("Fermata",2);
    Collection<Animal> animals = new ArrayList<>();


    }

    @Test
        public void TestGetCount() {
            Assert.assertEquals(0,this.farm.getCount());
        }

    @Test
    public void TestGetName() {
    Assert.assertEquals("Fermata",farm.getName());
    }

    @Test(expected =  IllegalArgumentException.class)
    public void TestAddingAnimalIfFarmIsFull() {

    farm.add(new Animal("raccoon",100));
    farm.add(new Animal("capybara",100));
    farm.add(new Animal("possum",100));
    }

    @Test
    public void TestAddAnimalWhenAvailableSpot() {
        farm.add(new Animal("raccoon",100));
        farm.add(new Animal("capybara",100));
        Assert.assertEquals(2,farm.getCount());
    }
    @Test(expected =  IllegalArgumentException.class)
    public void TestAddingAnimalIfItAlreadyExists() {
        farm.add(new Animal("raccoon",100));
        farm.add(new Animal("raccoon",200));

    }

    @Test
    public void TestRemovingAnimalNormal() {
        farm.add(new Animal("raccoon",100));
farm.remove("raccoon");
Assert.assertEquals(0,farm.getCount());
    }

    @Test (expected =IllegalArgumentException.class )
    public void TestInvalidCapacity() {
    farm = new Farm("Fermata 2",-1);
    }
    @Test (expected =NullPointerException.class)
    public void TestInvalidName() {
        farm = new Farm(null,2);
    }
}

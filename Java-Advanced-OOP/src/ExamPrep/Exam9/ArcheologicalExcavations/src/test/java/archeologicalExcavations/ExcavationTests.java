package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ExcavationTests {
    private Collection<Archaeologist> archaeologists;
    private Excavation excavation;
    private Archaeologist archaeologist;
    private Archaeologist archaeologist2;
    private Archaeologist archaeologist3;
    @Before
    public void setUp(){
        this.archaeologists=new ArrayList<>();
 excavation = new Excavation("test", 2);
         archaeologist = new Archaeologist("Indiana",100);
         archaeologist2 = new Archaeologist("Skalata",100);
         archaeologist3 = new Archaeologist("Bilbo",100);

    }

    @Test
    public void TestListSize() {
        Assert.assertEquals(0,excavation.getCount());
    }
    @Test
    public void TestExcavationName() {

        Assert.assertEquals("test",excavation.getName());
    }

    @Test
    public void TestAddArchaeologist() {
       excavation.addArchaeologist(archaeologist);
       Assert.assertEquals(1,excavation.getCount());
excavation.addArchaeologist(archaeologist2);
Assert.assertEquals(2,excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddArchThrowsException() {
        excavation.addArchaeologist(archaeologist);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);

    }

    @Test(expected = IllegalArgumentException.class)
    public void AddArchWithExistingName() {
        excavation.addArchaeologist(archaeologist);
        Archaeologist archaeologist4 = new Archaeologist("Indiana",102);
        excavation.addArchaeologist(archaeologist4);

    }

    @Test
    public void TestRemoveByName() {
        excavation.addArchaeologist(archaeologist);
excavation.removeArchaeologist("Indiana");
    }

    @Test
    public void RemoveNonExisting() {
        Excavation excavation = new Excavation("Test Excavation", 5);
        Assert.assertFalse(excavation.removeArchaeologist("Non-existing Archaeologist"));
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacity() {
        Excavation excavation = new Excavation("Test Excavation", -1);

    }
    @Test
    public void setCapacity2() {
        Excavation excavation = new Excavation("Test Excavation", 5);

    }

    @Test(expected = NullPointerException.class)
    public void TestNullName() {
        Excavation excavation = new Excavation(null, 5);

    }
    @Test(expected = NullPointerException.class)
    public void TestWhiteSpaceName() {
        Excavation excavation = new Excavation("", 5);

    }

    @Test
    public void TestNormalName() {
        Excavation excavation = new Excavation("Test", 5);
Assert.assertEquals("Test",excavation.getName());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWithNegative() {
        this.excavation.setCapacity(-1);
    }
}

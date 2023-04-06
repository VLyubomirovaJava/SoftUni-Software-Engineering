package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.*;

public class ToyStoryTest {
    private ToyStore toyStore;
    private Toy toy1;
    private Toy toy2;
    private Toy toy3;

    @Before
    public void setUp() {
        toyStore = new ToyStore();
        toy1 = new Toy("1234", "Teddy Bear");
        toy2 = new Toy("5678", "Barbie Doll");
        toy3 = new Toy("9012", "LEGO Set");
    }

    @Test
    public void testConfiguringShelves() {
        Map<String, Toy> toyShelf;
        toyShelf = new LinkedHashMap<>();
        toyShelf.put("A", null);
        toyShelf.put("B", null);
        toyShelf.put("C", null);
        toyShelf.put("D", null);
        toyShelf.put("E", null);
        toyShelf.put("F", null);
        toyShelf.put("G", null);
        assertEquals(toyShelf, toyStore.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddToyThrowsExceptionIfToyIsExisting() throws OperationNotSupportedException {
        Toy toy1 = new Toy("TestOwner", "TestItem");
        Toy toy2 = new Toy("TestOwner", "TestItem2");

        toyStore.addToy("A", toy1);
        long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
        assertEquals(1, exist);
        toyStore.addToy("A", toy2);
    }

    @Test(expected = OperationNotSupportedException.class)
        public void addSameToyToTwoShelves() throws OperationNotSupportedException{
        Toy toy1 = new Toy("TestOwner", "TestItem");
        Toy toy2 = new Toy("TestOwner", "TestItem2");
        toyStore.addToy("A", toy1);
        toyStore.addToy("B", toy1);

    }
@Test (expected = IllegalArgumentException.class)
        public void addToyToFakeShelf() throws OperationNotSupportedException{
    Toy toy1 = new Toy("TestOwner", "TestItem");
toyStore.addToy("A23",toy1);
}
@Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingToyOnThisShelf() throws OperationNotSupportedException {
    Toy toy1 = new Toy("TestOwner", "TestItem");
    Toy toy2 = new Toy("TestOwner", "TestItem2");
    toyStore.addToy("A", toy1);
    toyStore.addToy("B", toy2);
    toyStore.removeToy("A",toy2);
    long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
    Assert.assertEquals(1, exist);
}
@Test
        public void removeToy() throws OperationNotSupportedException{
    Toy toy1 = new Toy("TestOwner", "TestItem");
    Toy toy2 = new Toy("TestOwner", "TestItem2");        
    toyStore.addToy("A", toy1);
    toyStore.addToy("B", toy2);
    String result = toyStore.removeToy("B",toy2);
    long exist = toyStore.getToyShelf().values().stream().filter(Objects::nonNull).count();
   Assert.assertEquals(1,exist);
   Assert.assertEquals("Remove toy:TestItem2 successfully!", result);
}
    }

package magicGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class MagicianTests {


    @Test(expected = NullPointerException.class)
    public void TestNullUsername() {
        Magician magician1 = new Magician(null, 100);
    }

    @Test
    public void TestNormalUsername() {
        Magician magician1 = new Magician("Yugi", 100);
        Assert.assertEquals("Yugi", magician1.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void TestEmptyUsername() {
        Magician magician1 = new Magician("", 100);
        Assert.assertEquals("", magician1.getUsername());

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestInvalidHealth() {
        Magician magician1 = new Magician("Yugi", -1);
    }

    @Test
    public void TestNormalHealth() {
        Magician magician1 = new Magician("Yugi", 100);
        Assert.assertEquals(100, magician1.getHealth());

    }

    @Test
    public void testDamage() {
        Magician magician1 = new Magician("Yugi", 100);
        magician1.takeDamage(50);
        Assert.assertEquals(50, magician1.getHealth());
    }

    @Test
    public void testDamage2() {
        Magician magician1 = new Magician("Yugi", 50);
        magician1.takeDamage(50);
        Assert.assertEquals(0, magician1.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowException() {
        Magician magician1 = new Magician("Yugi", 0);
        magician1.takeDamage(50);
    }

    @Test
    public void TestMagicAdding() {
        Magician magician1 = new Magician("Yugi", 100);
        Magic magic = new Magic("Abracadabra", 10);
        magician1.addMagic(magic);
        List<Magic> expected = List.of(magic);

        Assert.assertEquals(expected, magician1.getMagics());
    }

    @Test(expected = NullPointerException.class)
    public void AddMagicException() {
        Magician magician1 = new Magician("Yugi", 100);
        magician1.addMagic(null);
    }

    @Test
    public void TestMagicRemoving() {
        Magician magician1 = new Magician("Yugi", 100);
        Magic magic = new Magic("Abracadabra", 10);
        magician1.addMagic(magic);
        Assert.assertTrue(magician1.removeMagic(magic));
    }

    @Test
    public void TestGetMagic() {
        Magician magician1 = new Magician("Test Magician", 100);
        Magic magic = new Magic("Test Magic", 10);
        magician1.addMagic(magic);
        Assert.assertEquals(magic, magician1.getMagic("Test Magic"));

    }
    @Test
    public void TestGetMagicIfNull() {
        Magician magician1 = new Magician("Test Magician", 100);
        Magic magic = new Magic("Test Magic", 10);
        magician1.addMagic(magic);
        Assert.assertEquals(null, magician1.getMagic("Abracadabra"));

    }


}

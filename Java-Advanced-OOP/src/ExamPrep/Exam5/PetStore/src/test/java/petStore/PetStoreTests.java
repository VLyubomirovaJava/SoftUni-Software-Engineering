package petStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

public class PetStoreTests<AnimalShelter> {
    private PetStore petStore;
    private Animal animal;
    private List<Animal> animals;

    @Before
    public void setup() {
        petStore = new PetStore();
        animals = List.of(
                new Animal("Cat", 15, 20),
                new Animal("Dog", 10, 10),
                new Animal("Fish", 1, 2)
        );
    }
    @Test
    public void TestAddAnimalNormal() {
        Animal animal = new Animal("raccoon", 20, 100);
        petStore.addAnimal(animal);
        Assert.assertEquals(1, petStore.getCount());
    }


    @Test (expected = IllegalArgumentException.class)
    public void TestAddNullAnimal(){
        Animal animalNull = null;
        petStore.addAnimal(animalNull);
    }
@Test
    public void TestGetAnimals(){
        int expectedCount =     0;
        Assert.assertEquals(expectedCount,petStore.getCount());
}
@Test
    public void  TestFindingAnimalsWithMaxKg(){
    List<Animal> expected = animals.stream().filter(a -> a.getMaxKilograms() > 1).collect(Collectors.toList());
    animals.stream().forEach(a -> petStore.addAnimal(a));
    List<Animal> actual = petStore.findAllAnimalsWithMaxKilograms(1);
    Assert.assertEquals(expected.size(), actual.size());
}
@Test
    public void TestGettingAnimal(){
        animals.stream().forEach(animal1 -> petStore.addAnimal(animal1));
        List<Animal> actual = petStore.getAnimals();
        Assert.assertEquals(animals.size(),actual.size());
}
    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimalsShouldThrowExBecauseReturnUnmodifiableList() {
        animals.stream().forEach(a -> petStore.addAnimal(a));
        animal = new Animal("test", 50, 50);
        petStore.getAnimals().add(animal);
    }

    @Test
    public void TestFindMostExpensiveAnimal(){
        Animal animal1 = petStore.getTheMostExpensiveAnimal();
        Assert.assertNull(animal1);
    }
    @Test
    public void testGetTheMostExpensiveAnimalShouldReturnFirstAnimal() {
        animals.stream().forEach(a -> petStore.addAnimal(a));
        animal = new Animal("Fish", 10, 20);
        petStore.addAnimal(animal);
        Animal actual = petStore.getTheMostExpensiveAnimal();
        Assert.assertEquals("Cat", actual.getSpecie());
    }
    @Test
    public void testFindAllAnimalBySpecieShouldReturnEmptyList(){
        animals.stream().forEach(a -> petStore.addAnimal(a));
        List<Animal> actual = petStore.findAllAnimalBySpecie("NoSuchSpecie");
        Assert.assertEquals(0,actual.size());

    }
    @Test
    public void testFindAllAnimalBySpecieShouldReturnList(){
        animals.stream().forEach(a -> petStore.addAnimal(a));
        List<Animal> actual = petStore.findAllAnimalBySpecie("Cat");
        Assert.assertEquals(1,actual.size());

    }

}



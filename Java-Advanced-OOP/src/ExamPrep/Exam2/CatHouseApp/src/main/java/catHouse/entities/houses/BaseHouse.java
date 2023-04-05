package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.*;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.CAT_NAME_NULL_OR_EMPTY;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name==null || name.trim().isEmpty()){
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name =name;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public int sumSoftness() {
        int sum = 0;
        for (Toy toy: toys) {
            sum += toy.getSoftness();
        }
        return sum;
    }

    @Override
    public void addCat(Cat cat) {
      if (cats.size()+1>this.capacity){
          throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);

        }
      this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat:cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s:",this.name,this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Cats: ");
        if (cats.isEmpty()){
            sb.append("none");
        } else {
            sb.append(cats.stream().map(Cat::getName).collect(Collectors.joining(" ")));
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Toys: %d",toys.size()));
        sb.append(String.format(" Softness: %d",sumSoftness()));
return sb.toString();
    }

    }


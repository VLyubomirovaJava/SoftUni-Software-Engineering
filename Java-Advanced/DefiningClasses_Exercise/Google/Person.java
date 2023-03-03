package DefiningClasses_Exercise.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Pokemon> pokemonList;
    private Company company;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    // they can have only 1 company, only 1 car
    public Person() {
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();

    }

    public Person(Company company, Car car, List<Parents> parents, List<Children> children, List<Pokemon> pokemon) {
        this.company = company;
        this.car = car;
        this.parentsList = parents;
        this.childrenList = children;
        this.pokemonList = pokemon;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setParentsList(List<Parents> parentsList) {
        this.parentsList = parentsList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemonList() {
        return this.pokemonList;
    }

    public Company getCompany() {
        return this.company;
    }

    public List<Parents> getParentsList() {
        return this.parentsList;
    }

    public List<Children> getChildrenList() {
        return this.childrenList;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company:").append("\n");
        if (company != null) {
            sb.append(company).append("\n");
        }
        sb.append("Car:").append("\n");
        if (car != null) {
            sb.append(car).append("\n");
        }
        sb.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemonList) {
            sb.append(pokemon).append("\n");
        }
        sb.append("Parents:").append("\n");
        for (Parents parents : parentsList) {
            sb.append(parents).append("\n");
        }

        sb.append("Children:").append("\n");
        for (Children children : childrenList) {
            sb.append(children).append("\n");
        }
        return sb.toString();

    }
}
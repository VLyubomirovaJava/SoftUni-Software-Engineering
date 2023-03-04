package Exam18February.kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            this.registry.add(child);
            return true;
        }
        return false;

    }


    public boolean removeChild(String firstName) {
        return this.registry.removeIf(child -> child.getFirstName().equals(firstName));

    }

    public int getChildrenCount() {
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return registry.stream().filter(child -> child.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    public String registryReport() {
        registry.sort(Comparator.comparingInt(Child::getAge).thenComparing(Child::getFirstName).thenComparing(Child::getLastName));
        return "Registered children in " + name + ":" + System.lineSeparator() + "--" + System.lineSeparator() +
                registry.stream().map(Child::toString).collect(Collectors.joining(System.lineSeparator() + "--" + System.lineSeparator()));

    }
}

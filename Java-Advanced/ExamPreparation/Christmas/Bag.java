package ExamPreparation.Christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> presents;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.presents = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int count() {
        return this.presents.size();
    }

    public void add(Present present) {
        if (this.count() >= this.getCapacity()) {
            return;
        }
        this.presents.add(present);
    }

    public boolean remove(String name) {
        return this.presents.removeIf(present -> present.getName().equals(name));
    }

    public Present getPresent(String name) {
        for (Present present : presents) {
            if (present.getName().equals(name)) {
                return present;
            }
        }

        return null;
    }

    public String report() {
        String presentsString = this.presents
                .stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n"));

        return String.format("%s bag contains:\n%s", this.color, presentsString);
    }


    public Present heaviestPresent() {
        return this.presents.stream()
                .sorted((l, r) -> Double.compare(r.getWeight(), l.getWeight()))
                .limit(1)
                .collect(Collectors.toList())
                .get(0);
    }
}






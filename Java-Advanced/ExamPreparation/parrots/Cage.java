package ExamPreparation.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Parrot> getData() {
        return data;
    }

    public void setData(List<Parrot> data) {
        this.data = data;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }

    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        Parrot toReturn = null;
        for (Parrot parrot : this.data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                toReturn = parrot;
            }
        }
        return toReturn;

    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> toReturn = new ArrayList<>();
        for (Parrot p : this.data) {
            if (p.getSpecies().equals(species)) {
                p.setAvailable(false);
                toReturn.add(p);

            }
        }
        return toReturn;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        StringBuilder sb =new StringBuilder();
        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());
        for (Parrot parrot:this.data) {
            if (parrot.isAvailable()){
                sb.append(parrot.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}

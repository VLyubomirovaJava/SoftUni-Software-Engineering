package Encapsulation.AnimalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private boolean isValidAge(int input) {
        return input >= 0 && input <= 15;
    }


    private boolean isValidName(String string) {
        return !string.isBlank();
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalStateException("Name cannot be empty.");
        }
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (isValidAge(age)) {
            this.age = age;
        } else {
            throw new IllegalStateException("Age should be between 0 and 15.");
        }
    }

    private double calculateProductPerDay() {
        if (getAge() >= 0 && getAge() < 6) {
            return 2;
        } else if (getAge() >= 6 && getAge() <= 11) {
            return 1;
        }
        return 0.75;
    }

    public double productPerDay() {
        return calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Encapsulation.AnimalFarm.Chicken %s (age %d) ", getName(), getAge());
    }
}


package DefiningClasses_Exercise.RawData;

public class Tire {
    private int age;
    private double pressure;

    public Tire(double pressure, int age) {
        this.age = age;
        this.pressure = pressure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}

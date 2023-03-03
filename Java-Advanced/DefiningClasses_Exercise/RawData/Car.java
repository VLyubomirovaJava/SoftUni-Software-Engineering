package DefiningClasses_Exercise.RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private List<Tire> tires;
    private Cargo cargo;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.tires = tires;
        this.cargo = cargo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Tire> getTires() {
        return tires;
    }

    public void setTires(List<Tire> tires) {
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void extract(String cargoInput) {
        switch (cargoInput) {
            case "fragile":
                for (Tire tire : tires) {
                    double pressure = tire.getPressure();
                    if (pressure < 1) {
                        System.out.println(model);
                        break;
                    }
                }
                break;
            case "flamable":
                if (engine.getEnginePower() > 250) {
                    System.out.println(model);
                }
                break;
        }

    }
}

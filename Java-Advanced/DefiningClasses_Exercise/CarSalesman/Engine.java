package DefiningClasses_Exercise.CarSalesman;

public class Engine {
    private String Model;
    private int enginePower;
    private int engineDisplacement;
    private String engineEfficiency;

    public Engine(String engineModel, int enginePower, int engineDisplacement, String engineEfficiency) {
        this.Model = engineModel;
        this.enginePower = enginePower;
        this.engineDisplacement = engineDisplacement;
        this.engineEfficiency = engineEfficiency;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getEngineEfficiency() {
        return engineEfficiency;
    }

    public void setEngineEfficiency(String engineEfficiency) {
        this.engineEfficiency = engineEfficiency;
    }
}

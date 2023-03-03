package DefiningClasses_Exercise.SpeedRacing;

public class Car {
    //полета -> характеристики
    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int traveledDistance;
    //методи -> действия
    //getters -> осигуряват достъп до полетата
    //конструктор -> метод, чрез който ние създаваме обекти от класа

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.traveledDistance = 0;
    }

    public boolean drive(int kmDrive) {
        // needed fuel is equal to how many km we need to travel * fuel-costs per car model
        double neededFuelForTrip = kmDrive * this.fuelCostPerKm;
        if (neededFuelForTrip <= this.fuelAmount) {
            this.fuelAmount -= neededFuelForTrip;
            this.traveledDistance += kmDrive;
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.traveledDistance);

    }
}

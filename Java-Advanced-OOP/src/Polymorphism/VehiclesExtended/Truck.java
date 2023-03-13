package Polymorphism.VehiclesExtended;

public class Truck extends Vehicle {

public static double ADDITIONAL_AC_CONSUMPTION=1.6;
public static double FUEL_LEAK_CORRECTION_PERCENTAGE=0.95;
    public Truck(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption ,tankCapacity, ADDITIONAL_AC_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * FUEL_LEAK_CORRECTION_PERCENTAGE);
    }
    }



package christmasRaces.core.interfaces.cars;

public interface Car {
    String getModel();

    int getHorsePower();

    double getCubicCentimeters();

    double calculateRacePoints(int laps);
}

package christmasRaces.core.interfaces.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {
    private final static double CENTIMETERS_SPORTS = 3000;
    private final static int MINIMUM_HORSEPOWER_SPORTS = 250;
    private final static int MAXIMUM_HORSEPOWER_SPORTS = 450;


    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CENTIMETERS_SPORTS);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSEPOWER_SPORTS || horsePower > MAXIMUM_HORSEPOWER_SPORTS) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);

    }
}



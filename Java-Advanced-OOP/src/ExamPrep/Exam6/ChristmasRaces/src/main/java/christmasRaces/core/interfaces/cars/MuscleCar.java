package christmasRaces.core.interfaces.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {
    private final static double CENTIMETERS_MUSCLE = 5000;
    private final static int MINIMUM_HORSEPOWER_MUSCLE = 400;
    private final static int MAXIMUM_HORSEPOWER_MUSCLE = 400;


    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CENTIMETERS_MUSCLE);
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < MINIMUM_HORSEPOWER_MUSCLE || horsePower > MAXIMUM_HORSEPOWER_MUSCLE) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);

    }
}

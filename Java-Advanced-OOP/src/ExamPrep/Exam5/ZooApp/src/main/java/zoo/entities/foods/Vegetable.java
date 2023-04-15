package zoo.entities.foods;


public class Vegetable extends BaseFood {
private final static int CALORIES_VEG=50;
private final static double PRICE_VEG=5;

    public Vegetable() {
        super(CALORIES_VEG, PRICE_VEG);
    }
}

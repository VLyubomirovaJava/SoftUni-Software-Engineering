package zoo.entities.areas;

public class WaterArea extends BaseArea {
private final static int CAPACITY_WATER_AREA=10;

    public WaterArea(String name) {
        super(name, CAPACITY_WATER_AREA);
    }
}

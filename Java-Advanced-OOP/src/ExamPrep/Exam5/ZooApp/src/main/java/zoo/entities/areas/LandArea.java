package zoo.entities.areas;

import java.util.*;

public class LandArea  extends BaseArea{
    private final static int CAPACITY_LAND_AREA=25;

    public LandArea(String name) {
        super(name, CAPACITY_LAND_AREA);
    }
}

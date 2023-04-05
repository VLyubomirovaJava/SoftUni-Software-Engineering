package catHouse.entities.toys;

import java.util.*;

public class Mouse extends BaseToy {
    private final static int SOFTNESS_MOUSE = 5;
    private final static double PRICE_MOUSE = 15;

    public Mouse() {
        super(SOFTNESS_MOUSE, PRICE_MOUSE);
    }
}

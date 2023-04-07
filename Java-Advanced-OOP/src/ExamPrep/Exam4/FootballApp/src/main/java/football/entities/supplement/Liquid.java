package football.entities.supplement;

import java.util.*;

public class Liquid extends BaseSupplement{
    private final static int ENERGY_LIQUID=90;
    private final static double PRICE_LIQUID=25;

    public Liquid() {
        super(ENERGY_LIQUID, PRICE_LIQUID);
    }
}



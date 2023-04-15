package restaurant.entities.tables;

import java.util.*;

public class InGarden extends BaseTable {
private final static double PRICE_BASIC =4.50;

    public InGarden(int number, int size) {
        super(number, size, PRICE_BASIC);
    }
}

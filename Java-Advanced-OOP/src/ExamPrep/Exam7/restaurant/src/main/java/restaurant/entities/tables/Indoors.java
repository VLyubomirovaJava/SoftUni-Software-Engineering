package restaurant.entities.tables;

import java.util.*;

public class Indoors extends  BaseTable{
        private final static double PRICE_INDOOR =3.50;

    public Indoors(int number, int size) {
        super(number, size, PRICE_INDOOR);
    }
}

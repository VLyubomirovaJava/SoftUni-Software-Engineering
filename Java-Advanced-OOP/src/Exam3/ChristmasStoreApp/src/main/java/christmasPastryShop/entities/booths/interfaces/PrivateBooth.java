package christmasPastryShop.entities.booths.interfaces;

import java.util.*;

public class PrivateBooth extends BaseBooth {
    private final static double PRICE_PER_PERSON_PRIVATE_BOOTH =3.50;

    public PrivateBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON_PRIVATE_BOOTH);
    }
}

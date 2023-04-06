package christmasPastryShop.entities.booths.interfaces;

public class OpenBooth extends BaseBooth {
private final static double PRICE_PER_PERSON_OPEN_BOOTH =2.50;
    public OpenBooth(int boothNumber, int capacity) {
        super(boothNumber, capacity, PRICE_PER_PERSON_OPEN_BOOTH);
    }
}

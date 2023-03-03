package workingWithAbstraction.HotelReservation;

public class PriceCalculator {
    public static double calculateHolidayPrice(double pricePerDay, int daysCount, Season Season, Discount discount) {
        int multiplier = Season.getValue();
        double discountMultiplier = discount.getValue() / 100.0;
        double priceBeforeDisc = daysCount * multiplier * pricePerDay;
        double discountedAmount = priceBeforeDisc * discountMultiplier;
        return priceBeforeDisc - discountedAmount;
    }


}

package workingWithAbstraction.HotelReservation;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
String[] input = scanner.nextLine().split("\\s+");
double pricePerDay =Double.parseDouble(input[0]);
int days = Integer.parseInt(input[1]);
Season season = Season.valueOf(input[2]);
Discount discountType = Discount.valueOf(input[3]);
double holidayPrice =PriceCalculator.calculateHolidayPrice(pricePerDay,days,season,discountType);
        System.out.printf("%.2f",holidayPrice);
    }
}

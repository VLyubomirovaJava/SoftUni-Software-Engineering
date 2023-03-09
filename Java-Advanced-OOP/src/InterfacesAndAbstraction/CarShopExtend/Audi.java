package InterfacesAndAbstraction.CarShopExtend;

public class Audi extends CarImpl implements Rentable {
private Integer minRentPerDay;
private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String country, Integer minRentPerDay, Double pricePerDay) {
        super(model, color, horsePower, country);
        this.minRentPerDay = minRentPerDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentPerDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }
    @Override
    public String toString() {
        return String.format("Minimum rental period of %s days. Price per day %f",getMinRentDay(),getPricePerDay());
    }
}

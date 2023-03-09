package InterfacesAndAbstraction.CarShopExtend;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsePower, String country,Double price) {
        super(model, color, horsePower, country);
        this.price = price;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String countryProduced() {
        return country;
    }

    @Override
    public String toString() {

        return String.format("%n%s sells for %f",getModel(),getPrice());
    }

    @Override
    public Double getPrice() {
        return price;
    }
}

package DefiningClasses_Exercise.CatLady;

public class StreetExtraordinaire extends Cat {
    private double meowDecibels;

    public StreetExtraordinaire(String name, double meowDecibels) {
        super(name);
        this.meowDecibels = meowDecibels;
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s %.2f", getName(), meowDecibels);
    }
}

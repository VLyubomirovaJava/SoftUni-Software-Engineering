package DefiningClasses_Exercise.Google;

public class Parents {
    private String name;
    private String birthday;

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;


    }

    @Override
    public String toString() {
        return name + " " + birthday + " ";
    }
}

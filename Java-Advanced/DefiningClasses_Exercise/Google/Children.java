package DefiningClasses_Exercise.Google;

public class Children {
    private String kidName;
    private String birthdayOfKid;

    public Children(String kidName, String birthdayOfKid) {
        this.kidName = kidName;
        this.birthdayOfKid = birthdayOfKid;


    }


    @Override
    public String toString() {
        return kidName + " " + birthdayOfKid + " ";
    }
}

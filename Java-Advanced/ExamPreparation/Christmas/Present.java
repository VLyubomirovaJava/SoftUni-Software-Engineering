package ExamPreparation.Christmas;

public class Present {
    private String Name;
    private double Weight;
    private String Gender;

    public Present(String name, double weight, String gender) {
        Name = name;
        Weight = weight;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return String.format("Present %s (%.2f) for a %s", getName(), getWeight(), getGender());
    }
}

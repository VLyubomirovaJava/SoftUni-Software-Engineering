package DefiningClasses_Exercise.Google;

public class Company {
    private String companyName;
    private String department;
    private Double salary;

    public Company(String companyName, String department, Double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return String.format("%s %s %.2f", companyName, department, salary);
    }
}

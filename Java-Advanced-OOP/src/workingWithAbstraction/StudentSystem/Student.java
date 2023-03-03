package workingWithAbstraction.StudentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }


    public String getCommentary() {
        String commentary = String.format("%s is %s years old.", name, age);
        if (grade >= 5.00) {
            commentary += " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            commentary += " Average student.";
        } else {
            commentary += " Very nice person.";
        }
        return commentary;
    }

}



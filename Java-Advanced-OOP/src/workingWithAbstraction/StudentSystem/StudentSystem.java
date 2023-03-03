package workingWithAbstraction.StudentSystem;
import java.util.HashMap;

public class StudentSystem {
    private HashMap<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }



    public void ParseCommand(String[] args) {
        String firstArgument = args[0];
        String name = args[1];
        if (firstArgument.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!repo.containsKey(name)) {
                Student student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (firstArgument.equals("Show")) {
            Student student = repo.get(name);
            if (student!= null){
                String commentary = student.getCommentary();

                System.out.println(commentary);
            }
        }
    }
}

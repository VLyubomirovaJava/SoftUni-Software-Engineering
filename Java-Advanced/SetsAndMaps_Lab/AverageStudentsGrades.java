package SetsAndMaps_Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsData = new TreeMap<>();
        for (int i = 0; i < studentCount; i++) {
            String[] gradeData = scanner.nextLine().split("\\s+");
            String name = gradeData[0];
            Double currentGrade = Double.parseDouble(gradeData[1]);
            studentsData.putIfAbsent(name, new ArrayList<>());
            studentsData.get(name).add(currentGrade);
        }
        for (Map.Entry<String, List<Double>> entry : studentsData.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            double gradeSum = 0;
            for (Double grade : entry.getValue()) {
                System.out.printf("%.2f ", grade);
                gradeSum += grade;
            }
            System.out.printf("(avg: %.2f)%n", gradeSum / entry.getValue().size());
        }
    }
}

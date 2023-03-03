package SetsAndMaps_Lab;

import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int studentCount = Integer.parseInt(scanner.nextLine());
        Map<String, Double[]> graduationList = new TreeMap<>();
        for (int i = 0; i < studentCount; i++) {
            String studentName = scanner.nextLine();
            String[] stringsOfScores = scanner.nextLine().split("\\s+");
            Double[] scores = new Double[stringsOfScores.length];

            for (int j = 0; j < stringsOfScores.length; j++) {
                scores[j] = Double.parseDouble(stringsOfScores[j]);

            }
            graduationList.put(studentName, scores);
        }
        graduationList.forEach((key, value) -> {
            double gradeSum = 0;
            for (Double grade : value) {
                gradeSum += grade;
            }
            System.out.printf("%s is graduated with %s%n", key, gradeSum / value.length);
        });
    }
}

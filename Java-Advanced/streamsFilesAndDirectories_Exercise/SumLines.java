package streamsFilesAndDirectories_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        for (String line : allLines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);

        }


    }
}
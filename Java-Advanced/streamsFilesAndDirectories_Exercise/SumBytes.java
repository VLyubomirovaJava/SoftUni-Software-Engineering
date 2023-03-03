package streamsFilesAndDirectories_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        int sum = 0;

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);


    }
}

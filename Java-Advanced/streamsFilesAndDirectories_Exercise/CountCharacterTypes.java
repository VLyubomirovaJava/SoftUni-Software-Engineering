package streamsFilesAndDirectories_Exercise;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        int vowelCount = 0;
        int otherCount = 0;
        int punctuationCount = 0;

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                //•	a, e, i, o, u 
                if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                    vowelCount++;

                } else if (symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?') {
                    //(! , . ?)
                    punctuationCount++;
                } else if (symbol != ' ') {
                    otherCount++;

                }
            }


        }
        System.out.println("Vowels: " + vowelCount);
        System.out.println("Other symbols: " + otherCount);
        System.out.println("Punctuation: " + punctuationCount);

    }
}
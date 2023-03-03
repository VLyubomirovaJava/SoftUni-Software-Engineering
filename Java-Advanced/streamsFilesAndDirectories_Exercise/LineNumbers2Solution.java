package streamsFilesAndDirectories_Exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class LineNumbers2Solution {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\inputLineNumbers.txt";

        PrintWriter printWriter = new PrintWriter(new FileWriter("output2.txt"));
        List<String> allLines = Files.readAllLines(Path.of(path));
        int lineNumber = 1;
        for (String line : allLines) {
            printWriter.println(lineNumber + ". " + line);
            lineNumber++;
        }
        printWriter.close(); // stop writing, closing the file
    }
}
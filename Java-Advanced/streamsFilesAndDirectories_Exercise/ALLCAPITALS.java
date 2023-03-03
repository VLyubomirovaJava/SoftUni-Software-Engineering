package streamsFilesAndDirectories_Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\output.txt"));
        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine();
        }
        writer.close();
    }
}

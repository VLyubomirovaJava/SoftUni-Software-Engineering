package streamsFilesAndDirectories_Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SumBytes2Solution {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt";
        byte[] allBytes = Files.readAllBytes(Path.of(path));
        int sum = 0;
        for (byte ascii : allBytes) {
            if (ascii != 10 && ascii != 13) {
                // skipping carriage return & new line symbols
                sum += ascii;
            }
        }
        System.out.println(sum);

    }
}


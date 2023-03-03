package streamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt\\";
        FileInputStream in = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String output = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\output.txt\\";
        PrintWriter writer = new PrintWriter(new FileOutputStream(output));
        String line = reader.readLine();
        int counter = 1;
        while (line != null) {
            line = reader.readLine();
            counter++;
            if (counter % 3 == 0) {
                writer.println(line);
            }
        }
        writer.close();
    }

}

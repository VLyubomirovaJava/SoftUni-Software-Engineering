package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt\\";
        String output = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\output.txt\\";
        FileInputStream in = new FileInputStream(path);
        Scanner scanner = new Scanner(in);
        PrintWriter out = new PrintWriter(new FileOutputStream(output));
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                out.println(scanner.nextInt());
            } else {
                scanner.next();
            }

        }
        out.close();
    }
}


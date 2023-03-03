package streamsFilesAndDirectories_Exercise;

import java.io.*;
import java.util.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException, InterruptedException {
        int ctr = 0;
        String path = "C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\inputLineNumbers.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\inputLineNumbers.txt"));
        PrintWriter printWriter = new PrintWriter(new FileWriter("NewQuickBrownFox.txt"));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            ctr++;
            printWriter.println(ctr + ". " + str);
            Thread.sleep(500);

        }
        printWriter.close();
        bufferedReader.close();
    }
}
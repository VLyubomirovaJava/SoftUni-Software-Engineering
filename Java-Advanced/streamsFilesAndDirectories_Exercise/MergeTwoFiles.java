package streamsFilesAndDirectories_Exercise;

import java.io.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter("file3.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\inputOne.txt"));
        String line = bufferedReader.readLine();
        while (line != null) {
            pw.println(line);
            line = bufferedReader.readLine();
        }
        bufferedReader = new BufferedReader(new FileReader("C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\inputTwo.txt"));
        line = bufferedReader.readLine();
        while (line != null) {
            pw.println(line);
            line = bufferedReader.readLine();
        }
        pw.flush();
        bufferedReader.close();
        pw.close();

    }
}
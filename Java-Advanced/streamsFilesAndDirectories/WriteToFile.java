package streamsFilesAndDirectories;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class WriteToFile {
    public static void main(String[] args) {
        String path = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt\\";
        String output = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\output.txt\\";
        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');
        try (InputStream in = new FileInputStream(path);
             OutputStream out = new FileOutputStream(output)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
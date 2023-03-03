package streamsFilesAndDirectories;

import java.io.*;
import java.util.*;

public class CopyBytes {
    public static void main(String[] args) {

        String path = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\input.txt\\";
        String output = "\\C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\output.txt\\";
        try (InputStream in = new FileInputStream(path);
             OutputStream out = new FileOutputStream(output)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
                }


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
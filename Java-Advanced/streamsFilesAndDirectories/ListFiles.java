package streamsFilesAndDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\Streams,FIles\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        if (file.exists()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.isDirectory()) {
                    System.out.println(f.getName() + ": [" + f.length() + "]");
                }
            }
        }


    }
}
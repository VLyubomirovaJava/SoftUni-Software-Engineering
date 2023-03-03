package streamsFilesAndDirectories_Exercise;

import java.io.File;
import java.util.*;

public class GetFolderSize {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\vasilinalyubomirova\\OneDrive - Paysafe\\Desktop\\Exercises Resources");
        ArrayDeque<File> dirQueue = new ArrayDeque<>();
        dirQueue.offer(file);
        int sumByte = 0;
        while (!dirQueue.isEmpty()) {
            File current = dirQueue.poll();
            File[] files = current.listFiles();
            for (File entry : files) {
                if (entry.isDirectory()) {
                    dirQueue.offer(entry);
                } else {
                    sumByte += entry.length();
                }
            }
        }
        System.out.println("Folder size: " + sumByte);
    }
}





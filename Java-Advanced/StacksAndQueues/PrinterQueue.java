package StacksAndQueues;

import java.util.*;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
// 1. receive file names
        // 2. preserve file names in a queue - queue. offer()
// we update the input( we get new files, until we receive "print" -> while cycle
        // 3.if we receive ''cancel'' - we remove first file to be printed -> queue.poll()
        // 3.1if we get cancel, but queue is empty- print printer is ready ( a if check queue.IsEmpty
        //  print the queue files on each go using pollFirst()

        String currentFile = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>(); // to save our files
        while (!currentFile.equals("print")) {

            if (currentFile.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.remove());
                }
            } else {
                queue.offer(currentFile);
                }
                currentFile = scanner.nextLine();
            }
        for (String s:queue) {
            System.out.println(s);
        }
    }
    }



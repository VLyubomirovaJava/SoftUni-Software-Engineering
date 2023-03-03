package StacksAndQueues;

import java.util.*;

public class BasicQueueOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] checkQueue = scanner.nextLine().split("\\s+");
        int countToAdd = Integer.parseInt(checkQueue[0]);
        int countToPoll = Integer.parseInt(checkQueue[1]);
        int wantedNum = Integer.parseInt(checkQueue[2]);

        String[] queueNumbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < countToAdd; i++) {
            queue.add(Integer.parseInt(queueNumbers[i])); // adding as many numbers , as  indicated by "countToAdd"
        }
        for (int i = 0; i < countToPoll; i++) { //// removing as many numbers , as  indicated by "countToPoll"
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println("0");
        } else if (queue.contains(wantedNum)) {
            System.out.println("true");
        } else {
            int minNum = Collections.min(queue);
            System.out.println(minNum);
        }
    }
}
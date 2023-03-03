package ExamPreparation;

import java.util.*;

public class Bouquets {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String tulipisInput = scanner.nextLine();
        String daffodilInput = scanner.nextLine();
// tulips are in stack
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        // daffodils -> queue
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();

        Arrays.stream(tulipisInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);
        Arrays.stream(daffodilInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);

        int bouquets = 0;
        int leftFlowers = 0;
        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tulip = tulips.peek();
            int daffodil = daffodils.peek();
            int sum = tulip + daffodil;
            if (sum == 15) {
                bouquets++;
                tulips.pop(); // removing last added item in stack
                daffodils.poll(); // removing last added item in queue
            } else if (sum > 15) {
                tulips.pop();
                tulips.push(tulip - 2);
            } else if (sum < 15) {
                leftFlowers += sum;
                tulips.pop();
                daffodils.poll();
            }
        }
        int bouquetsFromLeftFlowers = leftFlowers / 15;
        bouquets += bouquetsFromLeftFlowers;
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);

        }
    }

}

package ExamPreparation;

import java.util.*;

public class FlowerWreaths {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String liliesInput = scanner.nextLine();
        String rosesInput = scanner.nextLine();
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        fillStack(liliesInput, lilies);
        fillQueue(rosesInput, roses);

        int wreaths = 0;
        int leftFlowers = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lily = lilies.peek();
            int rose = roses.peek();
            int sum = rose + lily;
            if (sum == 15) {
                wreaths++;
                roses.poll();
                lilies.pop();
            } else if (sum > 15) {
                lilies.push(lily - 2);
            } else if (sum < 15) {
                leftFlowers += sum;
                roses.poll();
                lilies.pop();
            }
        }
        int leftFlowerWraths = leftFlowers / 15;
        wreaths += leftFlowerWraths;
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);

        }
    }


    private static void fillStack(String liliesInput, ArrayDeque<Integer> lilies) {
        Arrays.stream(liliesInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);
    }

    private static void fillQueue(String rosesInput, ArrayDeque<Integer> roses) {
        Arrays.stream(rosesInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(roses::offer);
    }
}
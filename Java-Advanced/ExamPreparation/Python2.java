package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Python2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());

        List<String> commands = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        char[][] field = new char[dimensions][dimensions];

        int snakeRow = -1;
        int snakeCol = -1;
        int pythonLength = 1;
        int foodCounter = 0;

        for (int row = 0; row < dimensions; row++) {
            String[] colData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < dimensions; col++) {
                field[row][col] = colData[col].charAt(0);

                if (field[row][col] == 's') {
                    snakeRow = row;
                    snakeCol = col;
                } else if (field[row][col] == 'f') {
                    foodCounter++;
                }
            }
        }

        for (String command : commands) {

            switch (command) {

                case "left":
                    if (snakeCol - 1 >= 0) {
                        snakeCol--;
                    } else {
                        snakeCol = field.length - 1;
                    }
                    break;

                case "right":
                    if (snakeCol + 1 < field.length) {
                        snakeCol++;
                    } else {
                        snakeCol = 0;
                    }
                    break;

                case "up":
                    if (snakeRow - 1 >= 0) {
                        snakeRow--;
                    } else {
                        snakeRow = field.length - 1;
                    }
                    break;

                case "down":
                    if (snakeRow + 1 < field.length) {
                        snakeRow++;
                    } else {
                        snakeRow = 0;
                    }
                    break;

            }
            if (field[snakeRow][snakeCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (field[snakeRow][snakeCol] == 'f') {
                pythonLength++;
                foodCounter--;
            }
        }
        if (foodCounter == 0) {
            System.out.printf("You win! Final python length is %d", pythonLength);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCounter);
        }
    }
}



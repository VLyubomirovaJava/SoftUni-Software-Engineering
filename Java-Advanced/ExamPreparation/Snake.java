package ExamPreparation;

import java.util.*;

public class Snake {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = scanner.nextLine().split("");
            field[i] = input;
        }
        int snakeRow = 0;
        int snakeCol = 0;
        boolean outOfBounds = false;
        int foodCount = 0;
        //finding where is our snake
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j].equals("S")) {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }
        String direction = scanner.nextLine();
        field[snakeRow][snakeCol] = ".";
        while (!direction.equals("")) {
            switch (direction) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }
            // to avoid invalid field range
            if (snakeRow >= 0 && snakeRow < size && snakeCol >= 0 && snakeCol < size) {
                if (field[snakeRow][snakeCol].equals("B")) {
                    field[snakeRow][snakeCol] = ".";
                    for (int row = 0; row < size; row++) {
                        for (int col = 0; col < size; col++) {
                            if (field[row][col].equals("B") && row != snakeRow && col != snakeCol) {
                                //the end of the lair
                                snakeRow = row;
                                snakeCol = col;
                                field[snakeRow][snakeCol] = ".";
                            }
                        }
                    }
                } else if (field[snakeRow][snakeCol].equals("*")) {
                    foodCount++;
                    field[snakeRow][snakeCol] = ".";
                } else {
                    field[snakeRow][snakeCol] = ".";
                }
            } else {
                outOfBounds = true;
            }
            if (outOfBounds || foodCount == 10) {
                break;
            }

            direction = scanner.nextLine();
        }
        if (outOfBounds) {
            System.out.println("Game over!");
        } else {
            field[snakeRow][snakeCol] = "S";
        }
        if (foodCount == 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d\n", foodCount);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%s", field[i][j]);
            }
            System.out.println();
        }
    }
}


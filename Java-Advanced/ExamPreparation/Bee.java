package ExamPreparation;

import java.util.*;


public class Bee {
    private static int[] beePosition = new int[2];
    public static int row = -1;
    public static int column = -1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        fillMatrix(scanner, matrix);
        int polinatedFlowers = 0;
        String direction = scanner.nextLine();
        while (!direction.equals("End")) {

            row = beePosition[0];
            column = beePosition[1];
            matrix[row][column] = '.';

            moveBee(direction);
            if (!isOutBounds(matrix, row, column)) {

                if (matrix[row][column] == 'O') {
                    matrix[row][column] = '.';
                    moveBee(direction);
                }
                if (matrix[row][column] == 'f') {
                    polinatedFlowers++;
                }
                matrix[row][column] = 'B';
                beePosition[0] = row;
                beePosition[1] = column;
            } else {
                System.out.println("The bee got lost!");
                break;
            }
            direction = scanner.nextLine();
        }
        if (polinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", polinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - polinatedFlowers);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static boolean isOutBounds(char[][] matrix, int row, int column) {
        return row < 0 || row >= matrix.length || column < 0 || column >= matrix.length;

    }


    private static void moveBee(String direction) {
        switch (direction) {
            case "left":
                column--;
                break;
            case "right":
                column++;
                break;
            case "up":
                row--;
                break;
            case "down":
                row++;
                break;
        }
    }

    private static void fillMatrix(Scanner scanner, char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            String data = scanner.nextLine();
            if (data.contains("B")) {
                beePosition[0] = row;
                beePosition[1] = data.indexOf("B");
            }
            for (int i = 0; i < data.length(); i++) {
                matrix[row][i] = data.charAt(i);
            }
        }
    }
}


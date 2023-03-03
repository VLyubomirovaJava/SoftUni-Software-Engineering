package MultidimentionalArrays;

import java.util.*;

public class MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        fillMatrixWithInput(scanner, matrix);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (validateCommand(command, rows, cols)) {
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];
                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();

        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validateCommand(String command, int rows, int cols) {
        String[] commandParts = command.split("\\s+");
        //  count of elements ->5
        if (commandParts.length != 5) {
            return false;
        }
        // it needs to start with swap
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        // check if given parts of the command are valid(>=0 & < rows, cols)
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);
        if (row1 >= rows || row1 < 0 || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }
        // otherwise the command is valid:
        return true;
    }

    private static void fillMatrixWithInput(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");

        }
    }
}

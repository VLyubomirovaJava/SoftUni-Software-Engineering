package Exam18February;

import java.util.*;

public class BlindMansBuff {
    static int row;
    static int col;
    static int madeMoves;
    static int touchedPlayers;
    static char[][] matrix;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().split("\\s+")[0]);
        matrix = new char[n][];
        //finding our initial location
        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine().replace(" ", "");
            if (data.contains("B")) {
                row = i;
                col = data.indexOf("B");
            }
            matrix[i] = data.toCharArray();
        }
        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);

                    break;
                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
            }
            if (touchedPlayers == 3) {
                break;
            }
            command = scanner.nextLine();

        }
        System.out.println("Game over!");
        System.out.println("Touched opponents: " + touchedPlayers + " Moves made: " + madeMoves);
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;
        //to avoid going out of the matrix with invalid indexes
        if (nextRow < 0 || nextCol < 0 || nextCol == matrix.length || nextRow == matrix.length) {
            return;
        }
        if (matrix[nextRow][nextCol] == 'O') {
            return;
        }
        madeMoves++;
        if (matrix[nextRow][nextCol] == 'P') {
            touchedPlayers++;
        }
        row = nextRow;
        col = nextCol;
    }
}
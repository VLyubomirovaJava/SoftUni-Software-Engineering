package MultidimentionalArrays;

import java.util.*;

public class CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] firstMatrix = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
        }
        row = scanner.nextInt();
        column = scanner.nextInt();
        int[][] secondMatrix = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }
        }

        //comparing the 2 matrices
        if (compareMatrices(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        // Check if the number of rows and columns match
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        }
        // Compare each element of the matrices
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
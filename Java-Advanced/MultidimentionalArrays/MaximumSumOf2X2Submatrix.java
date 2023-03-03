package MultidimentionalArrays;

import java.util.*;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] details = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(details[0]);
        int cols = Integer.parseInt(details[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(", ");
            for (int column = 0; column < cols; column++) {
                matrix[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }
        // Initialize variables to store maximum sum and submatrix
        int maxSum = Integer.MIN_VALUE;
        int[][] maxSubMatrix = new int[2][2];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int submatrixSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (submatrixSum > maxSum) {
                    maxSum = submatrixSum;
                    maxSubMatrix[0][0] = matrix[i][j];
                    maxSubMatrix[0][1] = matrix[i][j + 1];
                    maxSubMatrix[1][0] = matrix[i + 1][j];
                    maxSubMatrix[1][1] = matrix[i + 1][j + 1];
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(maxSubMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}


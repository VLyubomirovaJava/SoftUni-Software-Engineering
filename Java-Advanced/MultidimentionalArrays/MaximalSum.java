package MultidimentionalArrays;

import java.util.*;

public class MaximalSum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        int[][] result = new int[3][3];

        //We use another nested for loop to iterate through each possible 3x3 submatrix of the matrix array.
        // The outer loop starts at the first row and goes up to the second-to-last row, and the inner loop starts at the first
        // column and goes up to the second-to-last column.
        // This is because a 3x3 submatrix needs to have a row and column to spare on either
        // side in order to be fully contained within the matrix array.

        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                //Inside the nested loop, we calculate
                // the sum of the current 3x3 submatrix using a series of additions. We add up the element at the current row and column,
                // the element to the right of it, and the element to the right of that.
                // Then we add the element on the next row of the current column,
                // the element on the next row to the right of it,
                // and the element on the next row to the right of that.
                // Then we add the element on the row below the next row,
                // the element on the row below the next row to the right of it,
                // and the element on the row below the next row to the right of that.


                int currentSum = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2]
                        + matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];

                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    startRow = r;
                    startCol = c;

                }
            }
        }
        System.out.println("Sum = " + maxSum);
        //e use two nested for loop to print the elements of the 3x3 submatrix with maximum sum.
        // The outer loop starts at the maximum row, and goes up to the maximum row + 3
        // (to print three rows) and the inner loop starts at the maximum column and goes up
        // to the maximum column +3 (to print three columns) of the submatrix.
        for (int row = startRow; row <= startRow + 2; row++) {
            for (int col = startCol; col <= startCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }


}


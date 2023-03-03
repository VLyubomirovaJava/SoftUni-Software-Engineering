package MultidimentionalArrays;

import java.util.*;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        for (int r = 0; r < size; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
// main diagonal
        int row = 0;
        int col = 0;
        while (row < size && col < size) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();
        // secondary diagonal
        row = size - 1;
        col = 0;
        while (row >= 0 && col < size) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }

}
//Here, for main diagonal, we are iterating through the rows and columns of the matrix with the same index i,
// which will always start from the first element in the first row and first column. And for the secondary diagonal, we are iterating through the rows and columns of the matrix with the same index i, but this time we are subtracting i from the last column index,
// which will always start from the last row and first column.
//
//This approach will work for square matrix,
// if the matrix is rectangular you will have to check the number
// of rows and columns to make sure that you are not going out of the boundaries of the matrix and adjust the indexes accordingly.
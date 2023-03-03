package MultidimentionalArrays;

import java.io.IOException;
import java.util.*;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt(); // number of rows in the matrix
        int C = scanner.nextInt(); // number of columns in the matrix
        int[][] matrix = new int[R][C]; // create a 2D array with R rows and C columns

        // read the matrix from the input
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // print the matrix diagonals in reversed order
        for (int row = R - 1; row >= 0; row--) {
            if (row == R - 1) {
                for (int col = C - 1; col >= 0; col--) {

                    System.out.print(matrix[row][col] + " ");
                    int dr = row;
                    int dc = col;

                    while (dr - 1 >= 0 && dc + 1 <= C - 1) {
                        System.out.print(matrix[dr - 1][dc + 1] + " ");
                        dc++;
                        dr--;
                    }
                    System.out.println();
                }
            } else {
                for (int col = 0; col < C; col++) {
                    System.out.print(matrix[row][col] + " ");
                    int dr = row;
                    int dc = col;

                    while (dr - 1 >= 0 && dc + 1 <= C - 1) {
                        System.out.print(matrix[dr - 1][dc + 1] + " ");
                        dr--;
                        dc++;
                    }
                    System.out.println();
                    col = C;
                }
            }
        }
    }
}

//This Java code is a solution for printing the diagonal elements of a matrix in reverse order. The main method first creates a 2D array with R rows and C columns, reads the matrix from the input using nested for loops, and then prints the matrix diagonals in reversed order.
//
//    The code first initializes a Scanner object to read the input from the user. It reads in the number of rows and columns in the matrix and creates a 2D array with the specified number of rows and columns.
//    The code then reads the matrix from the input using nested for loops. It iterates through each row and column of the matrix and assigns the value input by the user to the corresponding position in the array.
//    Next, The code prints the matrix diagonals in reversed order. It uses an outer for loop to iterate through each row of the matrix in reverse order, starting from the last row.
//    In the outer for loop, the code checks if the current row is the last row of the matrix. If it is, the code uses an inner for loop to iterate through each column of the last row in reverse order, starting from the last column.
//    For each column of the last row, the code prints the value of the matrix at that position and then uses a while loop to traverse the diagonal elements of the matrix in reverse order, starting from the current position.
//    The while loop increments the column index and decrements the row index until the row index is less than 0 or the column index is greater than the number of columns in the matrix.
//    When the while loop exits, it prints a new line, which separates the diagonal elements of the current column from the next column.
//    If the current row is not the last row of the matrix, the code uses another inner for loop to iterate through each column of the current row, starting from the first column.
//    For each column of the current row, the code prints the value of the matrix at that position and then uses a while loop to traverse the diagonal elements of the matrix in reverse order, starting from the current position.
//    The while loop decrements the column index and increments the row index until the row index is less than 0 or the column index is greater than the number of columns in the matrix.
//    When the while loop exits, it prints a new line, which separates the diagonal elements of the current column from the next column.
//
//In this way, it will print the matrix diagonals in reversed order.
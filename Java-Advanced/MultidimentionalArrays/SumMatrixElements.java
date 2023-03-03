package MultidimentionalArrays;

import java.util.*;

public class SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] details = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(details[0]);
        int cols = Integer.parseInt(details[1]);
        int[][] matrix = new int[rows][cols];
//The program uses nested for loops to iterate through each element of the matrix,
// the outer for loop for rows, inner for loop for columns.
// The program prompts the user to enter the value of
// each element, which is stored in the corresponding
// position of the matrix.

        for (int row = 0; row < rows; row++) {
            String[] inputTokens = scanner.nextLine().split(", ");
            for (int column = 0; column < cols; column++) {
                matrix[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }
        int sum = 0;
        //The program then uses nested for loops to iterate through each element of the matrix again.
        // The outer for loop for rows, inner for loop for columns.

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
//                //For each element, the program
//                adds the value of the element to
//                the sum variable.

                sum += matrix[row][col];
            }
        }
        System.out.println(matrix.length); //prints the number of rows
        System.out.println(matrix[0].length); //he number of columns
        System.out.println(sum); //sum of all elements
    }
}
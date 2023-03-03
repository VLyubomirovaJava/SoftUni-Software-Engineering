package MultidimentionalArrays;

import java.util.*;
//The given code is a Java program that finds the intersection of two matrices
// , represented by the char arrays firstMatrix and secondMatrix.
// The program does this by comparing each element of the two matrices,
// and if they are the same, it prints the element, otherwise it prints a '*'.

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //the program declares two variables, row and column, which will be used to store the number of rows and columns for the matrices.
        // The user is prompted to enter these values using the Scanner object.
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        //The program then creates the firstMatrix char array,
        // using the row and column values entered by the user.
        // The program uses nested for loops to iterate through each element of the matrix
        // and prompts the user to enter the value of each element.

        char[][] firstMatrix = new char[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                firstMatrix[r][c] = scanner.next().charAt(0);
            }
        }
        //Similarly, the program creates the secondMatrix char array,
        // using the same row and column values entered by the user

        char[][] secondMatrix = new char[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                secondMatrix[r][c] = scanner.next().charAt(0);
            }
        }
        //The program then calls the printIntersection() method, passing the two matrices,
        // firstMatrix and secondMatrix, as arguments.

        printIntersection(firstMatrix, secondMatrix);
    }
//Inside the printIntersection() method, the program uses nested
// for loops to iterate through each element of the firstMatrix.

    private static void printIntersection(char[][] firstMatrix, char[][] secondMatrix) {
//For each element, the program uses an if statement
// to check if the current element of firstMatrix is equal
// to the corresponding element of secondMatrix.

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                // print element value for equal
                // elements else *
                if (firstMatrix[i][j] == secondMatrix[i][j]) {
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();

        }
    }
}
package MultidimentionalArrays;

import java.util.*;


public class WrongMeasurements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //reading the matrix from user's input on console
        int row = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[row][];

        for (int r = 0; r < row; r++) {
            //reading row of the matrix
            //This loop will run for `row` number of times,
            // on each iteration it will read one row from the
            // user input using the readArray method
            matrix[r] = readArray(scanner);
        }
//reading the indexes of the invalid number
        //this will read the indexes of invalid number from
        // the user input using the readArray method
        int[] indexes = readArray(scanner);

        //getting the invalid number from the matrix
        int wrongValue = matrix[indexes[0]][indexes[1]];

        //ArrayList called fixInfo which will store the information
        // of the incorrect values' indexes and their correct values.

        ArrayList<int[]> fixInfo = new ArrayList<>();
        //iterate through the rows and cols of the matrix
        for (int r = 0; r < matrix.length; r++) {
            for (int col = 0; col < matrix[r].length; col++) {
                if (matrix[r][col] == wrongValue) {
                    //calculating the right value
                    //if the current element of the matrix is equal to the invalid number then call the calculateRightValue method
                    //to calculate the correct value for that element
                    int rightValue = calculateRightValue(matrix, r, col, wrongValue);
                    // add the current row, column and the correct value to the fixInfo ArrayList
                    fixInfo.add(new int[]{r, col, rightValue});
                }
            }
        }
        //iterating through the fixInfo arrayList and replacing the invalid number with the right value
        for (int[] info : fixInfo) {
            matrix[info[0]][info[1]] = info[2];
        }
        //printing matrix
        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }


    private static int calculateRightValue(int[][] matrix, int r, int col, int wrongValue) {
        int rightValue = 0;
//checking if the element is inbound and not equal to the invalid value
        //if yes then adding its value to the rightValue variable
        if (isInbound(matrix, r - 1, col) && matrix[r - 1][col] != wrongValue) {
            rightValue += matrix[r - 1][col]; //up
        }

        if (isInbound(matrix, r + 1, col) && matrix[r + 1][col] != wrongValue) {
            rightValue += matrix[r + 1][col];//down
        }

        if (isInbound(matrix, r, col - 1) && matrix[r][col - 1] != wrongValue) {
            rightValue += matrix[r][col - 1]; //left
        }
        if (isInbound(matrix, r, col + 1) && matrix[r][col + 1] != wrongValue) {
            rightValue += matrix[r][col + 1]; //right
        }

        return rightValue;

    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isInbound(int[][] matrix, int r, int col) {
        return r < matrix.length && r >= 0 && col < matrix[r].length && col >= 0;
    }

    private static boolean isOutOfBound(int[][] matrix, int r, int col) {
        return !isInbound(matrix, r, col);
    }
}

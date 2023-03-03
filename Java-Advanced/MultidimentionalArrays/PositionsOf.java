package MultidimentionalArrays;

import java.util.*;

public class PositionsOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] rowsCals = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsCals[0]);
        int cols = Integer.parseInt(rowsCals[1]);
//reading matrix
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(rowData[col]);
            }
        }
        int number = Integer.parseInt(scanner.nextLine());
        boolean weFoundIt = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == number) {
                    weFoundIt = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!weFoundIt) {
            System.out.println("not found");
        }
    }
}
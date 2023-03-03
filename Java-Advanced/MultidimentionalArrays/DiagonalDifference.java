package MultidimentionalArrays;

import java.util.*;

public class DiagonalDifference {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int r = 0; r < size; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        //primary diagonal
        int row = 0;
        int col = 0;
        int primarySum = 0;
        while (row < size && col < size) {
            primarySum += matrix[row][col];
            row++;
            col++;
        }
        // other diagonal
        row = size - 1;
        col = 0;
        int otherSum = 0;
        while (row >= 0 && col < size) {
            otherSum += matrix[row][col];
            row--;
            col++;
        }
        System.out.println(Math.abs(primarySum - otherSum));
    }
}
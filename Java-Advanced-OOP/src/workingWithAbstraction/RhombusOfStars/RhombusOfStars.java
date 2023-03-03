package workingWithAbstraction;

import java.util.*;

public class RhombusOfStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printRow(n);
    }

    private static void printRow(int n) {
        int space = n - 1;
        // main loop til we get max of rows(parent loop)

        for (int row = 0; row < n; row++) {
            // for initial space print, before the *
            for (int j = 0; j < space; j++)
                System.out.print(" ");
            //j+1 stars,j is set to 1, so that we don't print two rows of  single *, if 'n' is 1.

            for (int j = 1; j <= row; j++)
                System.out.print("* ");
            System.out.print("\n");
            space--;
        }
        // in reverse for second part of diamond
        space = 0;
        for (int row = n; row > 0; row--) {
            for (int j = 0; j < space; j++)
                System.out.print(" ");
            for (int j = 0; j < row; j++)
                System.out.print("* ");
            System.out.print("\n");
            space++;
        }
    }
}


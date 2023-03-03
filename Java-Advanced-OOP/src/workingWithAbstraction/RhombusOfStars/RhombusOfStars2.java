package workingWithAbstraction;

import java.util.*;

public class RhombusOfStars2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        printTop(n);
        printMid(n);
        printBottom(n);

        }



    private static void printTop(int n) {
        for (int row = 1; row <= n - 1; row++) {
printRow(n,row);
        }

    }

    private static void printRow(int n, int row) {
        // each row -> count of space = size - row; count of * = row
        // n =3  -> 1 row = space*space
        //                   2 row = space**
        for (int space = 1; space <= n -row ; space++) {
            System.out.print(" ");
        }
        printMid(row);
    }

    private static void printMid(int n) {
        for (int star = 1; star <= n; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
    private static void printBottom(int n) {
        for (int row =n- 1; row >=1 ; row--) {
            printRow(n,  row);
        }
    }
    }


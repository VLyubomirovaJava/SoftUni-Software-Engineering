package ExceptionHandling;

import java.util.*;

public class SquareRoot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
try {
    double sqrt = sqrt(input);
        System.out.printf("%.2f%n", sqrt);

}catch (IllegalArgumentException ignored ){
    System.out.println("Invalid");

} finally {
    System.out.println( "Goodbye");
}

    }

    private static double sqrt(String input) {
        int n = Integer.parseInt(input);
        if (n<0){
            throw new IllegalArgumentException("Invalid");
        }
        return Math.sqrt(n);
    }
}
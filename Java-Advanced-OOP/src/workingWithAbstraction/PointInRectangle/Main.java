package workingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
//x1y1
        int bottomLeftX = coordinates[0];
        int bottomLeftY = coordinates[1];
        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);

//x2y2
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int n = Integer.parseInt(scanner.nextLine());
        int x;
        int y;
        for (int i = 0; i < n; i++) {

            int[] coordinates2 = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            x = coordinates2[0];
            y = coordinates2[1];
            Point userPoint = new Point(x, y);
            System.out.println(rectangle.contains(userPoint));
        }
    }
}
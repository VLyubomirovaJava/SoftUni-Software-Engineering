package InterfacesAndAbstraction.Ferrari;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String driverName =scanner.nextLine();
Car car = new Ferrari(driverName);
        System.out.println(car);
    }
}
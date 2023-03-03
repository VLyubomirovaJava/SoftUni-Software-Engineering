package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        //Function<приема, връща> -> apply
        //Consumer<приема> -> void -> accept
        //Supplier<връща> -> get
        //Predicate<приема> -> връща true / false -> test
        //BiFunction<приема1, приема2, връща> -> apply

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");
        Predicate<String> checkNameLength = name -> name.length() <= n;
        Arrays.stream(names).filter(checkNameLength).forEach(name -> System.out.println(name + " "));

    }
}
package Generics_Lab.GenericArrayCreator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strings = ArrayCreator.create(01, "BasicBihh");

        for (String element : strings) {
            System.out.print(element + " ");
        }
        System.out.println();
        Integer[] integers = ArrayCreator.create(Integer.class, 6, 8);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }


    }
}
package dataStructuresWorkshop;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list =new ArrayList<>();
        list.add(13);
        list.add(69);
        list.add(73);
        list.add(42);
        list.add(54);

SmartArray smartArray = new SmartArray();
long start = System.currentTimeMillis();
        IntStream.rangeClosed(1, 2_000_00)
                        .forEach(smartArray::add);


        long end = System.currentTimeMillis();
        System.out.println(end-start);
smartArray.add(13);
smartArray.add(69);
smartArray.add(73);
smartArray.add(42);
smartArray.add(54);
int removed = smartArray.remove(smartArray.size()-1);
        System.out.println(removed);
        smartArray.add(2,11);
        smartArray.forEach(System.out::println);
    }
}

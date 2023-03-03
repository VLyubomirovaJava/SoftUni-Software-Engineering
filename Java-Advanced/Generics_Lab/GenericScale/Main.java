package Generics_Lab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> genericScale = new Scale<>("left", " right");
        System.out.println(genericScale.getHeavier());

        Scale<Integer> numberScale = new Scale<>(19, 91);
        System.out.println(numberScale.getHeavier());
    }
}
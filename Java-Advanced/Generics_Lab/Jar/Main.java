package Generics_Lab.Jar.JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> picklesJar = new Jar<>();
        picklesJar.add(99);
        picklesJar.add(1777);
        System.out.println(picklesJar.remove());

        Jar<String> pickledStringJar = new Jar<>();
        pickledStringJar.add("Look at me, Morty! ");
        pickledStringJar.add("I turned myself into a pickle, Morty! I am PICKLE RICK ");
        pickledStringJar.add("I don't do magic, Morty, I do science. One takes brains, the other takes dark eye liner. ");
        System.out.println(pickledStringJar.remove());
    }
}
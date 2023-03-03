package Generics_Lab.Jar.JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> content;

    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T element) {
        this.content.push(element);
    }

    public T remove() {
        //removing the first one
        return this.content.pop();

    }


}

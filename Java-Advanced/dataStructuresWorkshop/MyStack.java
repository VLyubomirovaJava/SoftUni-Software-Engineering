package dataStructuresWorkshop;


import org.w3c.dom.Node;

import java.util.function.Consumer;

public class MyStack {
    private static class Node {
        private int element;
        private Node prev;
        public Node(int element, Node prev){
            this.element=element;
            this.prev=prev;
        }
    }

    private Node top;
    private int size;

    public MyStack() {
    }

    public void push(int element) {
Node newNode = new Node(element,this.top);
this.top =newNode;
this.size++;
    }

    public int pop() {

    }

    public int peek () {

    }

    public void forEach(Consumer<Integer> consumer) {

    }
}
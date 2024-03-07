/**
 * this is an example of a nested class nested classes are classes that are defined within another class, and
 * are used to group related classes together.
 * <p>
 * <p>
 * nested classes can be static or non-static. if it's static, it can't access non-static members of the
 * outer class. each object of a non-static nested class is implicitly tied to an object of the outer class.
 * but a static nested class is not.
 * most of the time, a nested class is used to group classes that are only used in one place, and are not
 * used anywhere else.
 * example of static nested class:
 * iterator in a collection
 * examples of non-static nested class:
 * 1. a class that is used only in one place, and is not used anywhere else.
 * 2. a class that is used to group related classes together.
 */
package exceptions;

import java.util.Iterator;

class Stack {
    private Node head;

    static class Node {
        private int value;
        private Node next;
    }

    void add(int val) {
        Node newNode = new Node();
        newNode.value = val;
        newNode.next = head;
        if (head == null) {
            head = newNode;
            return;
        }
        head = newNode;
    }


    public class Iterator implements java.util.Iterator {

        private Node current;

        Iterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null && current.next != null;
        }

        @Override
        public Object next() {
            int value = current.value;
            current = current.next;
            return value;
        }
    }
}

public class Nested {
    public static void main(String[] args) {
        Stack stack = new Stack();
        Stack.Node node = new Stack.Node(); // can be created without outerclass instance
        System.out.println();
        for (int i = 0; i < 10; i++) {
            stack.add(i);
        }
        // must be tied to an existing outer class instance! hence the special syntax:
        for (Iterator iter = stack.new Iterator(); iter.hasNext(); ) {
            System.out.println(iter.next());
        }
    }
}

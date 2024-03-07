/**
 * in this example, we will meet the memento pattern.
 * the memento pattern is used to capture the state of an object, and store
 * it in a way that it can be restored later.
 *
 * to create a memento, we will do the following:
 * 1. create a class that will hold the state of the object we want to save.
 *       in our case, it will be a static inner class of the object we want to save named Memento.
 * 2. create a method in the object we want to save, that will return a memento.
 *       in our case, it will be a method named saveToMemento.
 * 3. create a method in the object we want to save, that will restore the state from a memento.
 *       in our case, it will be a method named restoreFromMemento.
 * */

package exceptions;

import java.util.ArrayList;
import java.util.List;

class Caretaker {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();
        Originator originator = new Originator();

        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());
        originator.set("State3");        // We can request multiple mementos, and choose which one to roll back to
        savedStates.add(originator.saveToMemento());
        originator.set("State4");
        originator.restoreFromMemento(savedStates.get(1));
    }
}

class Originator {
    private String state;
    public void set(String state) {
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    }
    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    }
    public void restoreFromMemento(Memento memento) {
        this.state = memento.state;
        System.out.println("Originator: State after restoring from Memento: " + state);
    }
    public static class Memento {
        private final String state;
        private Memento(String stateToSave) {
            state = stateToSave;
        }        // accessible by outer class only
    }
}

/**
 * in this class we have implemented the Subject interface and created a class called WhatsappMessage
 * this class is responsible for sending messages to the observers
 * this is an example of using the observer pattern
 * the class has a list of observers and a boolean variable to check if the data has changed
 * the class also has a method to attach an observer, remove an observer, notify the observers,
 * check if the data has changed, reset the changed variable and set the changed variable
 * the class also has a method to get the data
 * */

package observer_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhatsappMessage implements Subject {

    private List<Observer> observerList = new ArrayList<>();
    private String data = new String();
    private boolean changed = false;

    public WhatsappMessage() {
    }

    public String scanSystemIn() {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        data = line;
        setChanged();
        return line;
        }

    public String getData() {
        return data;
    }

    @Override
    public void attach (Observer observer){
        observerList.add(observer);
    }

    @Override
    public void remove (Observer observer){
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers () {
    if (hasChanged()) {
            for (Observer o : observerList) {
                o.update();
            }
            resetChanged();
        }
    }

    @Override
    public boolean hasChanged () {
        return changed;
    }

    @Override
    public void resetChanged () {
        changed = false;
    }


    @Override
    public void setChanged() {
        changed = true;
    }

}
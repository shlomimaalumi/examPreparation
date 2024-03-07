/**
 * the pattern of creating observe pattern is like this:
 * 1. create a subject interface that will have the methods to attach, remove and notify observers
 * 2. create a concrete class that will implement the subject interface
 * 3. create an observer interface that will have the method to update the observers
 * 4. create concrete classes that will implement the observer interface
 *
 * */
package observer_pattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Enter Text: ");
        WhatsappMessage textMessage = new WhatsappMessage();

        WhatsappPhone observer1 = new WhatsappPhone(textMessage, "Observer 1");
        WhatsappWeb observer2 = new WhatsappWeb(textMessage, "Observer 2");

        textMessage.attach(observer1);
        textMessage.attach(observer2);

        while(!textMessage.scanSystemIn().equals("")){
            textMessage.notifyObservers();
        };

    }
}
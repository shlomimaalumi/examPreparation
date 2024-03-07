package lab6;

import java.util.ArrayList;
import java.util.List;

/**
 In this assignment we will design a program that models a news-desk that receives news-flashes from a
 reporter, and notifies by push-notifications all app registered to get news updates. We will use the
 Observer-design-pattern.

 The interfaces NewsSubject and NewsObserver that fit the observer-pattern are supplied in the code.

 You will need to implement the objects in the following list:

 1. NewsDesk - represents a news desk that is in charge of spreading the news. You can assume that there
 will be no more than 10 observers that observe the news-desk.

 The class implements the NewsSubject interface. The API of the class has the following method:

 boolean registerObserver(NewsObserver observer) - is responsible to add an observer.
 boolean unregisterObserver(NewsObserver observer) - is responsible to remove an observer.
 void pushNotification(String newsFlash) - is responsible to store the new news-flash and update all
 registered apps that a new news-item arrived.
 void printNews() - prints all news items received until this point, with a newline between news items and
 the prefix ""News Summary:\n".
 2. Reporter - represents a reporter that is associated with a NewsDesk and publishes in the news-desk
 scoops that he discovers as news flashes.
 The API of the class has the following methods:
 Reporter(NewsDesk myNewsDesk) - constructor
 void discoveredScoop(String newsScoop) - activated when a new scoop is discovered and is responsible to
 publish it in the news desk.
 3. BrowserNewsApp - a news app for a browser. implements the NewsObserver interface.
 API:
 void pushNewsFlash(String newsFlash) - print the newsFlash with the prefix "Browser News App News Flash: "
 4. AndroidNewsApp - a news app for a browser. implements the NewsObserver interface.
 API:
 void pushNewsFlash(String newsFlash) - print the newsFlash with the prefix "Android News App News Flash: "
 5. IOSNewsApp - a news app for a browser. implements the NewsObserver interface.
 API:
 void pushNewsFlash(String newsFlash) - print the newsFlash with the prefix "IOS News App News Flash: "

 */




 /**
 * in this example, we are using the observer pattern to create a news desk that receives news flashes from a
 * reporter, and notifies all app registered to get news updates.
 * the design pattern of the observer is used to define a one-to-many dependency between objects so that when
 * one object changes state, all its dependents are notified and updated automatically.
 *
 * the format of observer pattern is as follows:
 * 1. create a subject interface with methods to register and unregister observers and a method to notify
 * observers of any change.
 * 2. create a concrete subject class that implements the subject interface. this class is also responsible
 * for storing the state of the subject and notifying all observers when the state changes.
 * 3. create an observer interface with a method to notify the observer of the change in subject.
 * 4. create concrete observer classes that implement the observer interface. these classes are responsible
 * for receiving the update from the subject and displaying it.
 *
 * */
interface NewsSubject {
    /**
     * Registers new observer
     *
     * @return true if succesful, false otherwise
     */
    boolean registerObserver(NewsObserver observer);

    /**
     * Unregisters observer
     *
     * @return true if succesful, false otherwise
     */
    boolean unregisterObserver(NewsObserver observer);

    /**
     * Notifies all observers with the new newsFlash
     */
    void pushNotification(String newsFlash);
}

interface NewsObserver {
    void pushNewsFlash(String newsFlash);
}

class NewsDesk implements NewsSubject {
    private final List<NewsObserver> observers = new ArrayList<>();
    private final List<String> news = new ArrayList<>();

    @Override
    public boolean registerObserver(NewsObserver observer) {
        return observers.add(observer);
    }

    @Override
    public boolean unregisterObserver(NewsObserver observer) {
        return observers.remove(observer);
    }

    @Override
    public void pushNotification(String newsFlash) {
        news.add(newsFlash);
        for (NewsObserver observer : observers) {
            observer.pushNewsFlash(newsFlash);
        }
    }

    public void printNews() {
        System.out.println("News Summary:");
        for (String n : news) {
            System.out.println(n);
        }
    }
}

class Reporter {
    private final NewsSubject myNewsDesk;

    Reporter(NewsDesk myNewsDesk) {
        this.myNewsDesk = myNewsDesk;
    }

    void discoveredScoop(String newsScoop) {
        myNewsDesk.pushNotification(newsScoop);
    }
}

class BrowserNewsApp implements NewsObserver {

    @Override
    public void pushNewsFlash(String newsFlash) {
        System.out.println("Browser News App News Flash: " + newsFlash);
    }
}

class AndroidNewsApp implements NewsObserver {

    @Override
    public void pushNewsFlash(String newsFlash) {
        System.out.println("Android News App News Flash: " + newsFlash);
    }
}

class IOSNewsApp implements NewsObserver {

    @Override
    public void pushNewsFlash(String newsFlash) {
        System.out.println("IOS News App News Flash: " + newsFlash);
    }
}

public class Observe____Subject {
    public static void main(String[] args) {
        NewsDesk newsDesk = new NewsDesk();
        Reporter pulitzerPrizeWinnerReporter = new Reporter(newsDesk);
        BrowserNewsApp browser = new BrowserNewsApp();
        AndroidNewsApp android = new AndroidNewsApp();
        IOSNewsApp ios = new IOSNewsApp();

        newsDesk.registerObserver(browser);
        pulitzerPrizeWinnerReporter.discoveredScoop("The world is going crazy!!!");

        newsDesk.registerObserver(android);
        newsDesk.registerObserver(ios);
        pulitzerPrizeWinnerReporter.discoveredScoop("The world is back to normal!!!");

        newsDesk.unregisterObserver(android);
        pulitzerPrizeWinnerReporter.discoveredScoop("The world is going crazy AGAIN!!!");

        newsDesk.printNews();
    }
}

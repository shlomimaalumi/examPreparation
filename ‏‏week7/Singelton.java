/**
 * in this example, we have a class that is a singleton, and we have a class that has a static method.
 * to implenet a singleton, we will:
 * 1. make the constructor private, so no one can create an instance of the class.
 * 2. create a static method that will return the instance of the class, and create it if it doesn't exist.
 * 3. create a private static field that will hold the instance of the class.
 *
 *
 * creating a singleton is useful when we want to have a single instance of a class, for example, a logger,
 * or a configuration class.
 * */

package exceptions;

interface StringHandler {
    String getString();
    void concatString(String s);
}
class Singleton implements StringHandler {

    private static Singleton singleton;

    private String theString;

    private Singleton() {
        theString="";
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public String getString() {
        return theString;
    }

    public void concatString(String s) {
        theString+=s;
    }
}
class StaticClass{
    private static String theString="";
    public static String getString() {
        return theString;
    }
    public static void concatString(String s) {
        theString+=s;
    }
}

class main{

    public static void main(String[] args) {
        Singleton singleton=Singleton.getInstance();
    }
    public void foo1(StringHandler singleton) {
        singleton.getString();
    }
    public void foo2() {
        StaticClass.getString();
    }
}

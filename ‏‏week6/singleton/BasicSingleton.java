/**
 * the singleton pattern is a design pattern that restricts the instantiation of a class to one object.
 * this is useful when exactly one object is needed to coordinate actions across the system.
 * the concept is sometimes generalized to systems that operate more efficiently when only one object exists,
 * or that restrict the instantiation to a certain number of objects.
 *
 * the pattern is in this format:
 * 1. a private constructor to restrict the instantiation of the class from other classes.
 * 2. a private static variable of the same class that is the only instance of the class.
 * 3. a public static method that acts as a constructor, and returns the instance of the class.
 * */

package singleton;

class Singleton {

	private static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (singleton != null) {
			return singleton;
		}
		singleton = new Singleton();
		return singleton;
	}
}

public class BasicSingleton {
	public static void main(String[] args) {
//        Singleton singleton = new Singleton(); // ERROR! private constructor
		Singleton singleton1 = Singleton.getInstance(); // will return the single object created
		Singleton singleton2 = Singleton.getInstance(); // these two objects are equal
		System.out.println(singleton1==singleton2);
	}
}

/**
 * in this example, we will create an abstract class that has fields, constructors,
 * implemented methods, and abstract methods we will then create a subclass that
 * extends the abstract class and implements the abstract method
 * the purpose of this example is to show the difference between an abstract class
 * and an interface
 *
 * the purpose of the constructor is to initialize the fields of the abstract class
 * the purpose of the implemented method is to provide a default implementation
 * the purpose of the abstract method is to force the extending subclass to implement it
 * the purpose of the subclass is to extend the abstract class and implement the abstract method
 *
 * to use the abstract class, we will create an instance of the subclass and call the
 * implemented method
 * */

package abstract_vs_interface;

public abstract class AbstractClass {
	// can have any type of field or method access modifier
	private int privateField;
	protected int protectedField;
	int packagePrivateField;
	public int publicField;

	// can have a constructor
	public AbstractClass(int privateField, int protectedField, int packagePrivateField, int publicField) {
		this.privateField = privateField;
		this.protectedField = protectedField;
		this.packagePrivateField = packagePrivateField;
		this.publicField = publicField;
	}

	// can have implemented methods
	public void implementedMethod() {
		// do something
	}

	// as well as abstract methods
	public abstract void abstractMethod(); // must be implemented by the extending subclass
}

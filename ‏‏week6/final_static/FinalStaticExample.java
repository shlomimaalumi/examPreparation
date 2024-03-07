/**
 * in this example, we will see how to use final and static keywords in Java.
 * static fields and methods are shared between all instances of a class, and can be accessed without creating an instance of the class.
 * final fields and methods can't be changed after they are initialized.
 *
 *
 * using static is used to create utility classes, or to create a singleton.
 * we will use final variables to create fields that are constant, and can't be changed.
 * using final and static together is common, and is used to create constants.
 * */

package final_static;

public class FinalStaticExample {
	/* final fields */
//    private final int a; //must initialize either when declared or in the constructor!
    private final int a=0; //fixed

	public final int[] arr = {1, 2, 3, 4, 5};


	/* static fields & methods */
	public static int b; //static fields are initialized to a default value, same as non-static, non-final fields
	public static final String ERROR_MESSAGE="This is an error message"; //fixed

	public static void staticPrintExample() {
		System.out.println("Static methods are cool");
//        System.out.println(a); // can't use non static fields
		System.out.println(b); //using static fields is allowed.
	}

	/* normal fields & methods  */
	public int c;

	public void instanceMethod() {
	}
}

class FinalStaticMain {

	public static void staticMethod() {}

	public void regularMethod() {
	}

	public static void main(String[] args) {
		FinalStaticExample example = new FinalStaticExample();
//        example.a = 5; // final won't allow me to change the value of primitives.
//        example.arr = new int[5]; //final won't allow me to change the value of a reference
		example.arr[0] = 10; // a final reference doesn't mean the object it points to is final!

//		System.out.println(example.b); // we shouldn't access static members through an object reference
		System.out.println(FinalStaticExample.b); // we should access static members through the class namespace
		FinalStaticExample.staticPrintExample(); // same for methods

		// static methods can only call static methods directly, or use references to call non-static methods
		staticMethod(); //static method (main) calls a static method is allowed
//        regularMethod(); // static method (main) calls a non-static method, which is not allowed
		example.instanceMethod(); //static methods can call non-static methods only through actual objects.
	}
}
/**
 * in this example we will see how to handle exceptions using try and catch blocks
 * we will also see how to use the throws keyword to declare that a method might throw an exception
 *
 * the idea of handling exceptions is to allow the program to continue running, even if an error occurs.
 * make sure to handle exceptions in the right place. if you can't handle an exception, you can throw it
 * to the calling method.
 * */

package exceptions;

import java.io.IOException;

class IsThisException {
} // must extend Throwable

class VerySpecificIOException extends IOException {
}

public class TryCatch {
	public static void main(String[] args) /*throws exceptions.IsThisException*/ {
		try {
			// divide an integer by zero
			int i = 5 / 0;
		} catch (ArithmeticException e) {
			System.out.printf("An exception occurred, %s\n", e);
		}
//        try {/* some code that might raise different exceptions*/}
//        catch (IOException eIO){/* handle IOException*/}
//        catch (ArithmeticException eA){/* handle ArithmeticException*/}
//        catch (Exception e){/* handle super type exception*/}


		try {
			throw new VerySpecificIOException();
		} catch (IOException Ve) {
			// we've caught it here using exception polymorphism
		}
	}
}

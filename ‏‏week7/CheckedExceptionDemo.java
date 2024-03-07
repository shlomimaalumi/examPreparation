/**
 * in this example we are throwing an IOException from method c
 * and catching it in the main method.
 * */
package exceptions;

import java.io.IOException;

public class CheckedExceptionDemo {
	public static void main(String[] args) {
		try {
			a();
		}catch (Exception e){

		}
	}

	public static void a() throws IOException{
		b();
	}

	public static void b() throws IOException{
        c();
	}

	public static void c() throws IOException {
		throw new IOException("An error occured in method c");
	}
}

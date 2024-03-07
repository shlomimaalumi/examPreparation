import java.util.function.BiFunction;
import java.util.function.Predicate;


class Main1 {
	public static void main(String[] args) {
        /* Use the Function<T, R> functional interface to Define a function
        that takes a string and returns the number of "a"s in the string */
		BiFunction<String, Character, Integer> charInString = (str, character) -> {
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == character) {
					count++;
				}
			}
			return count;
		};

		// Use the function to count the number of "a"s in a string
		String phrase = "Strawberries and Banana!";
		String shortStr="short str";

		System.out.println("The number of 'a's in the string is: " + charInString.apply(phrase,'a'));

		/* Use Predicate<T> to define a function that checks if a string is longer than 10 characters */
		Predicate<String> largeStr = str-> str.length()>10;
//
		System.out.println(largeStr.test(phrase));
		System.out.println(largeStr.test(shortStr));

	}
}


/**
 * Method reference example
 */
class Func {

	public static double raiseToIntegerPowerAndAdd(double num, int power) {
		return num + Math.pow(num, power);
	}

	public static void applyAndPrint(BiFunction<Double, Integer, Double> function, double a, int b) {
		System.out.println(function.apply(a, b));
	}

	public static void main(String[] args) {
		applyAndPrint(Func::raiseToIntegerPowerAndAdd, 5.5, 2); // without lambdas
		applyAndPrint((num, power) -> num + Math.pow(num, power), 5.5, 2); // with lambda implementing BiFunction
	}
}
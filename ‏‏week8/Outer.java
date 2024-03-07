/**
 * we can use functional programming tools to create a functional interface and use it to create a
 * lambda expression
 * to create a functional interface, we need to create an interface with a single abstract method.
 * we can use the @FunctionalInterface annotation to make sure that the interface is a functional interface.
 * we can use the lambda expression to create an instance of the functional interface.
 * additionally we can use anonymous classes to create an instance of the functional interface.
 *
 *
 * additional info:
 * - a functional interface can have more than one default methods. for example, the List interface has
 * many default methods, such as forEach, removeIf, and others.
 * - a functional interface can have more than one static methods. for example, the Predicate interface
 * has many static methods.
 * - a functional interface can have more than one abstract methods, but only one of them can be abstract.
 * for example, the Comparator interface has two abstract methods, but only one of them is abstract.
 *
 * */

@FunctionalInterface
interface BinaryOperation {
	void operation(int i, int j);
}



class Outer {


	BinaryOperation sum = (i, j) ->System.out.printf("%s + %s = %s%n", i, j, i + j);

	public static void main(String[] args) {

		new Outer().sum.operation(10, 7);
	}
}

@FunctionalInterface
interface UnaryOperation {
	void operation(int i);
}

class Outer1 {
	static UnaryOperation square = i -> System.out.println(i * i);

	public static void main(String[] args) {
		 Outer1.square.operation(12);
	}
}


///* version 1 - without using functional programming tools */
//class Outer1 {
//	static class Sum implements BinaryOperation {
//		@Override
//		public void operation(int i, int j) {
//			System.out.printf("%s + %s = %s%n", i, j, i + j);
//		}
//	}
//
//	BinaryOperation sum = new Sum();
//
//	public static void main(String[] args) {
//		new Outer1().sum.operation(10, 7);
//	}
//}
//
///* version 2 - using an anonymous class */
//class Outer2 {
//	BinaryOperation sum = new BinaryOperation() {
//		@Override
//		public void operation(int i, int j) {
//			System.out.printf("%s + %s = %s%n", i, j, i + j);
//		}
//	};
//
//	public static void main(String[] args) {
//
//		new Outer2().sum.operation(10, 7);
//	}
//}
//
///* version 3 - uses lambdas with input arguments type declaration */
//class Outer3 {
//	BinaryOperation sum =
//			(int i, int j) -> {
//				System.out.println(i + j);
//			};
//
//	public static void main(String[] args) {
//		new Outer3().sum.operation(10, 7);
//	}
//}
//
//
///* version 4 - without input arguments type declaration */
//class Outer4 {
//	BinaryOperation sum =
//			(i, j) -> {
//				System.out.println(i + j);
//			};
//
//	public static void main(String[] args) {
//		new Outer4().sum.operation(10, 7);
//	}
//}
//
//
///* version 5 - single input argument -> optional parentheses around it */
//class Outer5 {
//	UnaryOperation square =
//			i -> System.out.println(i * i);
//
//	public static void main(String[] args) {
//		new Outer5().square.operation(12);
//	}
//}
//
///* version 6 - one line function -> optional curly braces */
//class Outer {
//	BinaryOperation sum = (i, j) -> System.out.println(this.toString());
//
//	public static void main(String[] args) {
//		new Outer().sum.operation(10, 7);
//	}
//}

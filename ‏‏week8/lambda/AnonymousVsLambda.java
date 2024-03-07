/**
 * in this example, we are comparing the use of anonymous classes and lambdas.
 * in the first part, we are using an anonymous class to implement the Printable interface.
 * in the second part, we are using a lambda expression to implement the same interface.
 *
 * anonymous classes are used to create an instance of a class that implements an interface,
 * or extends a class. anonymous classes are useful when you need to create a class that is used only once.
 * lambdas are used to create an instance of a functional interface.
 * lambdas are useful when you need to create a class that is used only once.
 * types of interfaces that can be used with lambdas and anonymous classes:
 Predicate<T>       (   T -> boolean  )
 Supplier<T>        (  void -> T  )
 Consumer<T>        (  T -> void  )
 Function<T,R>      (  T -> R  )
 BiFunction<T,U,R>  (  (T,U) -> R  )
 BiPredicate<T,U>   (  (T,U) -> boolean  )
 UnaryOperator<T>   (  T -> T  )
 BinaryOperator<T>  (  (T,T) -> T  )


 * */

package lambda;

@FunctionalInterface
interface Printable {
	void print(String s);
}

public class AnonymousVsLambda {
	public static void main(String[] args) {
		/* Anonymous class */
		Printable a =new Printable() {
			@Override
			public void print(String s) {
				System.out.println(s);
			}
		};
		/* Lambda expression */
		Printable b = s-> System.out.println(s);

		a.print("   -> One may prefer Anonymous classes in their project");
		System.out.println();
		b.print("   -> Others prefer Lambdas");
	}
}
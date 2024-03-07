/**
 * shows that the local variable points is effectively final, and can be used in a lambda expression.
 * but if we try to change the value of points, the compiler will give an error.
 * (this is because the lambda expression is using the value of points, and if we change it,
 * the lambda expression will use the new value, which is not allowed.)
 * */

package lambda;

interface Employee {
	void employeeData(String name);
}

class LambdaEffectivelyFinalTest {
	public static void main(String[] args) {
		int points = 100;
		/* lambda expression */
		Employee employee = name ->
				System.out.printf("The employee %s has %s points: ", name, points);
//		points++;
		employee.employeeData("Sami");
	}
}
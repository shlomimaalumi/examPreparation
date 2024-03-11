package lab8;

import java.util.List;
import java.util.Arrays;

/** Part 1: Create UnaryCalculator and BinaryCalculator
 * the generic functional interfaces below this comment **/
@FunctionalInterface
interface UnaryCalculator<T> {
    T operation(T x);
}
@FunctionalInterface
interface BinaryCalculator<T> {
    T operation(T x, T y);

    default T chainOperation(List<T> arr){
        if(arr.size() == 0){
            return null;
        }

        if(arr.size() == 1){
            return arr.get(0);
        }

        T result = arr.get(0);

        for(int i = 1; i < arr.size(); i++){
            result = operation(result, arr.get(i));
        }

        return result;
    }
}




/** Part 2: Implement MathCalculator **/
class MathCalculator {
    public BinaryCalculator<Double> add = (Double x, Double y) -> x + y;
    public BinaryCalculator<Double> multiply = (Double x, Double y) -> x * y;
    public BinaryCalculator<Double> divide = (Double x, Double y) -> {
        if (y == 0) {
            System.out.println("divided by zero");
            throw new ArithmeticException("divided by zero");
        } else {
            return x / y;
        }
    };
    public BinaryCalculator<Double> power = (Double x, Double y) -> Math.pow(x,y);
    public UnaryCalculator<Double> inverseSquareRoot = (Double x) -> {
        if (x == 0) {
            System.out.println("divided by zero");
            throw new ArithmeticException("divided by zero");
        } else {
            return 1.0 / Math.sqrt(x);
        }
    };
}

/** Part 3: Implement StringCalculator **/

class StringCalculator {
    UnaryCalculator<Character> toUpperCase = x->Character.toUpperCase(x);
    BinaryCalculator<String> adder =  (x,y)->x+y;
}

public class Calculator{
    public static void main(String[] args) {
        MathCalculator calc = new MathCalculator();
        System.out.println("1 + 2 = " + calc.add.operation(1.0,2.0));
        System.out.println("5 * 7 = " + calc.multiply.operation(5.0, 7.0));
        System.out.println("Divide by zero test");

        try
        {
            calc.inverseSquareRoot.operation(0.0);
        }
        catch(ArithmeticException e){
            System.out.println("Caught arithmetic exception");
        }
        System.out.println("Inverse square root of zero test");
        try
        {
            calc.divide.operation(1.0, 0.0);
        }
        catch(ArithmeticException e){
            System.out.println("Caught arithmetic exception");
        }
        System.out.println("100 / 10 = " + calc.divide.operation(100.0, 10.0));
        System.out.println("3^4 = " + calc.power.operation(3.0, 4.0));
        System.out.println("1/sqrt(9) = " + calc.inverseSquareRoot.operation(9.0));
    }
}
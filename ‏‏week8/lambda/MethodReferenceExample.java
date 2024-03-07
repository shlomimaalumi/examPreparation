/**
 * this is an example of method reference
 * we can use method reference to refer to a method without invoking it
 * the way to do it is to use the :: operator
 * */

package lambda;

import java.util.List;

public class MethodReferenceExample {
    public void printWithExclamation(String message) {
        System.out.println(message + "!");
    }

    public static void main(String[] args) {
        MethodReferenceExample example = new MethodReferenceExample();
        List<String> messages = List.of("OOP", "IS", "COOL");
        messages.forEach(example::printWithExclamation);
    }
}

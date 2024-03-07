package exceptions.lab7;

/**
 *Write a class Person with a method greet() that takes in a name as an argument and returns a  greeting
 * message with the format "Hello, <name>!".
 *
 * The greet() method should throw a NullPointerException if the name is null.
 *
 * In the case the name is an empty string you should throw a IllegalNameException which should be an
 * exception class that you create.
 *
 * Then, write a method sayHello() that takes in a name as an argument and calls the greet() method. If
 * the name is valid, print the message.
 *
 * The sayHello() method should handle the NullPointerException and IllegalNameException exceptions by
 * printing an error message to the console saying:
 *
 * for NullPointerException it should say "Reference was null, please enter a valid name".
 *
 * for IllegalNameException it should say "The name was empty, please enter a valid name".
 *
 *
 *
 * Hints:
 *
 * Exceptions have built in messages, it can make the code cleaner, when creating IllegalNameException add a constructor that gets a string, and call super inside of it.
 *
 * To print the exception use the Throwable method getMessage.
 * */


/**
 * in this example, we will meet the exception handling in java.
 * in java, an exception is an event that occurs during the execution of a program that disrupts the
 * normal flow of instructions.
 * exceptions are used to handle errors and other exceptional events in java.
 * exceptions are created by the java runtime system and can be caught and handled by the user.
 *
 * in this specific example, we will create a class Person with a method greet() that takes in a name as
 * an argument and returns a greeting message with the format "Hello, <name>!".
 * the greet() method should throw a NullPointerException if the name is null.
 * in the case the name is an empty string you should throw a IllegalNameException which should be an
 * exception class that you create.
 * then, we will write a method sayHello() that takes in a name as an argument and calls the greet() method.
 * if the name is valid, print the message.
 *
 * the sayHello() method should handle the NullPointerException and IllegalNameException exceptions by
 * printing an error message to the console saying:
 * for NullPointerException it should say "Reference was null, please enter a valid name".
 * for IllegalNameException it should say "The name was empty, please enter a valid name".
 *
 * to print the exception use the Throwable method getMessage.
 *
 * */


class IllegalNameException extends Exception {
    public IllegalNameException(String message) {
        super(message);
    }
}

class Person {
    public String greet(String name) throws IllegalNameException, NullPointerException {
        if (name == null) {
            throw new NullPointerException("Reference was null, please enter a valid name");
        } else if (name.isEmpty()) {
            throw new IllegalNameException("The name was empty, please enter a valid name");
        } else {
            return "Hello, " + name + "!";
        }
    }

    public void sayHello(String name) {
        try {
            String message = greet(name);
            System.out.println(message);
        } catch (NullPointerException | IllegalNameException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.sayHello("John");
        person.sayHello(null);
        person.sayHello("");
    }
}

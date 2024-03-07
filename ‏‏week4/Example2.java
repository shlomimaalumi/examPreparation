/**
 * in this example we are using a class from a different package
 * we are using the Ocean class from the Pack2 package
 * and we are using the isSafeToSwim method from the Ocean class
 * */

import Pack2.Ocean;

class Main {
    public static void main(String[] args) {
        Ocean mediterranean = new Ocean(4,1);
        System.out.println("Is is safe to swim? \n" + mediterranean.isSafeToSwim());
    }
}



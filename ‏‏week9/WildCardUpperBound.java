package generics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

abstract class Creature {
}

abstract class Animal extends Creature {
    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    abstract public void makeSound();
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Whoof!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}



class WildCardUpperBound {
    private static void askAnimalsToMakeSound(List<? extends Animal> list) {
        for (Animal animal : list) {
            animal.makeSound();
        }
    }

    <T extends Animal> void foo(List<T> list) {
        // we can read from the list just the type of T and its supertypes
        // we can add to the list the type of T and its subtypes
        T t = list.get(0);
        list.add(t);
    }
    void foo2(List<? extends Animal> list) {
        // we can read from the list just the type of Animal and its supertypes
        // we can't add to the list anything except null
        Animal a = list.get(0);
        Object o=list.get(0);
//        list.add(a);
    }



    public static void main(String[] args) {

        //Animal List
        List<Animal> animalList = Arrays.asList(new Dog("Buddy"),
                new Cat("Marley"));
        askAnimalsToMakeSound(animalList);
        // Dog list
        List<Dog> dogList = Arrays.asList(new Dog("Buddy"),
                new Dog("Krembo"),
                new Dog("Lassy"));
        askAnimalsToMakeSound(dogList);


    }
}


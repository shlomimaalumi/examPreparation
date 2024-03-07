
import java.util.Arrays;
import java.util.List;

abstract class Creature{}

abstract class Animal extends Creature{
    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    abstract public void makeSound();
}

class Dog extends Animal{
    Dog(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println("Whoof!");
    }
}

class Cat extends Animal{
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
        for(Animal animal: list){
            animal.makeSound();
        }
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


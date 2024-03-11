package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class WildCardLowerBound {
	public static void addInteger(List<? super Integer> list) {
		list.add(1);
		System.out.println("number 1 added to list");
	}
	public static void main(String[] args) {
		// Integer List is being passed
		List<Integer> list1 = Arrays.asList(4,5,6,7);
		addInteger(list1);

		// Number list is being passed
		List<Number> list2 = Arrays.asList(4,5,6,7);
		addInteger(list2);
	}

}
class A{}
class B extends A{}
class C extends B{}
class LowerBound {
	public static void addToList(List<? super B> list) {
		// we can read from the list just the type of Object
		// we can add to the list the type of B and its subtypes
		list.add(new B());
		list.add(new C());
		//list.add(new A()); // compilation error
		A a = (A) list.get(0);
		B b = (B) list.get(0);
		C c = (C) list.get(1);
		Object o = list.get(0);


	}
	public static void addDogToList(List<? super Dog> list, Dog element){
		list.add(element);
	}
	public static void main(String[] args) {
		List<Creature> creatures = new ArrayList<>();
		List<Animal> animals = new ArrayList<>();
		List<Animal> dogs = new ArrayList<>();
		Dog dog = new Dog("Buddy");
		addDogToList(creatures,dog);
		addDogToList(animals,dog);
		addDogToList(dogs,dog);
	}
}



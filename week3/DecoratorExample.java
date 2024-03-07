/**
 * the idea of using decorator pattern is to add new functionality to an object without
 * altering its structure.
 * the pattern is in this format:
 *
 * 1. Interface: the interface that the object will implement
 * 2. Concrete class: the object that will implement the interface
 * 3. Decorator: the object that will add the new functionality to the concrete class
 * in the example below, we have a fish interface, a baby fish concrete class and a gold
 * and stripes decorator.
 *
 * */


interface Fish {
	String getDescription();
}

class BabyFish implements Fish {
	@Override
	public String getDescription() {
		return "fish";
	}
}
interface FishDecorator extends Fish {}

class Gold implements FishDecorator {
	Fish fish;

	public Gold(Fish fish) {
		this.fish = fish;
	}

	@Override
	public String getDescription() {
		return "Gold "+fish.getDescription();
	}
}

class Stripes implements FishDecorator {

	Fish fish;
	private String color;

	public Stripes(Fish fish, String color) {
		this.fish = fish;
		this.color = color;
	}

	@Override
	public String getDescription() {
		return color+" Stripes "+fish.getDescription();
	}
}

class DecoratorExample {

	public static void main(String[] args) {
		Fish clownFish = new BabyFish();
		clownFish = new Gold(clownFish);
		clownFish = new Stripes(clownFish, "White");

		//Alternative initilize
		//Fish clownFish = new Stripes(new Gold(new BabyFish()),"White");
		System.out.println("A Clown fish is: a "+clownFish.getDescription());
	}
}
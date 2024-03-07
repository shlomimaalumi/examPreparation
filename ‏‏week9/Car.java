package generics;

public class Car <T>{
	T plateId;

	public Car(T plateId) {
		this.plateId = plateId;
	}

	public T getId() {
		return plateId;
	}
}

class Main {
	public static void main(String[] args) {
		Car car = new Car(12345);
		System.out.println((Integer) car.getId() + 1);
	}
}

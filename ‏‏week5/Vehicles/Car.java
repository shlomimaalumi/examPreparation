package Vehicles;


import Vehicles.Engines.Engine;

public class Car extends Vehicle{
    private Engine engine;
    public Car(String make, String model, int numSeats, FUEL fuelType, Engine engine){
        super(make,model,numSeats,fuelType);
        this.engine=engine;
    }

    @Override
    public void drive() {
        // drive a car on the road
        engine.spin();
    }
}

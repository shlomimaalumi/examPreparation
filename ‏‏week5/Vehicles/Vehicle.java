package Vehicles;

enum FUEL {GASOLINE,DIESEL,ELECTRIC,JET_FUEL};
public abstract class Vehicle {
    private String make;
    private String model;
    private int numSeats;
    private FUEL fuelType;
    public Vehicle(String make, String model, int numSeats, FUEL fuelType){
        this.make = make;
        this.model = model;
        this.numSeats = numSeats;
        this.fuelType = fuelType;
    }

    public abstract void drive();

}

package Vehicles;

public class Plane extends Vehicle{
    public Plane(String make, String model, int numSeats){
        super(make,model,numSeats,FUEL.JET_FUEL);
    }

    @Override
    public void drive() {
        // fly a plane in the air
    }
}

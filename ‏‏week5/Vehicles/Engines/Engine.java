package Vehicles.Engines;

public abstract class Engine {
    private int rpm;
    private int horsePower;

    protected Engine(int rpm, int hp) {
        this.rpm = rpm;
        horsePower = hp;
    }

    public abstract void spin();
}

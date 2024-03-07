package Vehicles.Engines;

public class ElectricEngine extends Engine {

    protected ElectricEngine(int rpm, int hp) {
        super(rpm, hp);
    }

    @Override
    public void spin() {
        // use electricity to spin the engine
    }
}

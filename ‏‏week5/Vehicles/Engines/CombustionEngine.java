package Vehicles.Engines;

public class CombustionEngine extends Engine {

    public CombustionEngine(int rpm, int hp) {
        super(rpm, hp);
    }

    @Override
    public void spin() {
        // use regular fuel to spin
    }
}

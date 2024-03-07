/**
 * in this exmaple, we have a class Ocean that extends WaterSource the Ocean class has a method isSafeToSwim
 * that returns true if the depth is less than or equal to 2 and the wave speed is less than or equal to 20
 */

package Pack2;

import Pack1.WaterSource;

public class Ocean extends WaterSource {
    String name = "Ocean";

    private static final double SAFE_WAVE_SPEED = 20;
    private double waveSpeed;

    //add constructor

    public Ocean(int depth, double waveSpeed) {
//        super(depth);
//        super();
        this.waveSpeed = waveSpeed;
    }


    //add isSafeToSwim()


    @Override
    public boolean isSafeToSwim() {
        return depth <= DEEP && waveSpeed <= SAFE_WAVE_SPEED;
    }

}


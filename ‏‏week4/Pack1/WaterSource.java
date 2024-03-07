/**
 * in this class we have a protected variable and a protected method
 * */

package Pack1;

public class WaterSource{
    String name="Water Source";
    protected static final int DEEP = 2;
    protected int depth;

    //add constructor


//    protected WaterSource(int depth) {
//        this.depth = depth;
//    }
//    public WaterSource(){}

    public boolean isSafeToSwim() {
        return depth <= DEEP;
    }

}

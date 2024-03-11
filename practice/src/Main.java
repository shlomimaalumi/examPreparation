;



import java.util.*;

interface Weaponable {
    public int fire();

    public int quality();

    public default void printQuality() {
        System.out.println(getClass() + ": " + quality());
    }
}

class Torpedo implements Weaponable {

    @Override
    public int fire() {
        return 43;
    }

    @Override
    public int quality() {
        return 100;
    }
}


class Ship<W extends Weaponable> implements Comparable<Ship<W>> {
    private int life = 100;
    private final W weapon;

    Ship(W weapon) {
        this.weapon = weapon;
    }

    Ship(Ship<W> other) {
        this.weapon = other.weapon;
    }

    public void attack(Ship<? extends Weaponable> other) {
        other.getHit(this.weapon.fire());
    }

    public void getHit(int val) {
        life -= val;
    }

    @Override
    public int compareTo(Ship<W> other) {
        if (weapon.quality() > other.weapon.quality()) {
            return 1;
        }
        if (weapon.quality() < other.weapon.quality()) {
            return 1;
        }
        return 0;
    }
}

class ShieldedShip<W extends Weaponable> extends Ship<W> {
    private static final Random RANDOM = new Random();
    private final Ship<W> _ship;

    ShieldedShip(Ship<W> ship) {
        super(ship);
        _ship = ship;
    }

    @Override
    public void getHit(int val) {
        _ship.getHit(Math.max(0, val - RANDOM.nextInt(1, 26)));
    }
}

class Cloacked<W extends Weaponable> extends Ship<W> {
    private static final Random RANDOM = new Random();
    private final Ship<W> _ship;

    Cloacked(Ship<W> ship) {
        super(ship);
        _ship = ship;
    }

    @Override
    public void getHit(int val) {
        if (RANDOM.nextInt(0, 4) == 0) {
            _ship.getHit(val);
        }
    }
}

class Shipyard {
    List<Ship<Torpedo>> yard = new ArrayList<>();

    public List<Ship<Torpedo>> sort(String order) {
        Comparator<Ship<Torpedo>> c = (c1, c2) -> {
            if (order.equals("lth")) {
                return c1.compareTo(c2);
            }
            return -c1.compareTo(c2);
        };
        List<Ship<Torpedo>> yard2 = new ArrayList<>();
        yard.sort(c);
        return yard2;
    }
}

@FunctionalInterface
interface Operation {
    double EQ(double d1, double d2);
}

class calculator {
    private final static Map<String, Operation> m = Map.of(
            "ADD", (d1, d2) -> d1 + d2,
            "MULT", (d1, d2) -> d1 * d2);

    public static double eval(String str) {
        String[] strs = str.split(" ");
        return m.get(strs[1]).EQ(Double.parseDouble(strs[0]), Double.parseDouble(strs[2]));
    }
    public static void addOperation(String name, Operation operation){

    }
}


class Main3 {
    public static void main(String[] args) {
        System.out.println(calculator.eval("3 ADD 2"));

    }
}

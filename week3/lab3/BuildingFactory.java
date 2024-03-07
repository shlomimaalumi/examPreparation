package lab3;
/**
 * In the code below we have an interface Building and three classes that implement it:
 * <p>
 * AzrieliTriangle - The triangle building in the Azrieli Towers CinemaCity - The round building of Cinema
 * City in Jerusalem CSEBuildingA - The rectangle building "A" of the CSE school buildings. Each building
 * class implements the interface methods getName and getVolume. Class BuildingsManager has a main method
 * that received as input a building name and constructs the requested building.
 * <p>
 * The assignment: Correct the design, using principles from this week's lectures: 1. Create a factory class
 * named BuildingFactory. 2. Add to BuildingFactory a method called buildBuilding. The method takes as input:
 * a buildingName its base and its height and returns the corresponding Building instance. 3. Fix the code of
 * BuildingsManager so it will use BuildingFactory instead of creating the buildings itself.
 */


/**
 * in this example, we are using the factory design pattern to create a factory class that will create
 * instances of the Building interface.
 * the format of creating a factory class is as follows:
 * 1. create a class that will be the factory class.
 * 2. create a method in the factory class that will create instances of the interface.
 * 3. in the method, use a switch statement to create the correct instance of the interface.
 * 4. in the main method, use the factory class to create instances of the interface.
 * */
import java.text.DecimalFormat;

interface Building {
    double getVolume();

    String getName();
}

class AzrieliTriangle implements Building {
    private double width, height;

    public AzrieliTriangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return 0.5 * Math.pow(width, 2) * height;
    }

    @Override
    public String getName() {
        return "Azrieli Triangle";
    }
}


class CinemaCity implements Building {
    private double radius, height;

    public CinemaCity(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return Math.pow(radius, 2) * Math.PI * height;
    }

    @Override
    public String getName() {
        return "Cinema City";
    }
}

class CSEBuildingA implements Building {
    private double area, height;

    public CSEBuildingA(double area, double height) {
        this.area = area;
        this.height = height;
    }

    @Override
    public double getVolume() {
        return area * height;
    }

    @Override
    public String getName() {
        return "CSEBuilding A";
    }
}

class BuildingsManager {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    private Building buildBuilding(String buildingName, double base, double height) {
        switch (buildingName) {
            case "Azrieli":
                return new AzrieliTriangle(base, height);
            case "CinemaCity":
                return new CinemaCity(base, height);
            case "CSE":
                return new CSEBuildingA(base, height);
            default:
                return null;
        }
    }

    class BuildingFactory {
        public static Building buildBuilding(String buildingName, double base, double height) {
            switch (buildingName) {
                case "Azrieli":
                    return new AzrieliTriangle(base, height);
                case "CinemaCity":
                    return new CinemaCity(base, height);
                case "CSE":
                    return new CSEBuildingA(base, height);
                default:
                    return null;
            }
        }


}


    public static void main(String[] args) {
        String a1="Azrieli";
        String a2="10";
        String a3="20";
        Building building = BuildingFactory.buildBuilding(a1, Double.parseDouble(a2),
                Double.parseDouble(a3));

        System.out.printf("The volume of %s is %s m^3 \n", building.getName(),
                df.format(building.getVolume()));
    }
}
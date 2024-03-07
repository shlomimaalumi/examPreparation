package lab4;


/**
 * in this example, we are using inheritance to create a drawing board.
 * we have a base class called Shape, and two subclasses called Circle and Square.
 * we implement a method called draw that takes a Shape object as a parameter.
 * the following code demonstrates the use of inheritance and polymorphism.
 * */

class DrawingBoard {

    public static void main(String[] args) {
        DrawingBoard board = new DrawingBoard();
        board.draw(new Circle(7));
        board.draw(new Square(4));
    }

    public void draw(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("Drawing "+ shape.getName()+ " with radius " + shape.getBase());
        } else if (shape instanceof Square) {
            System.out.println("Drawing square with width " + ((Square)shape).getWidth());
        }
    }
}


class Shape {
    private final int base;
    private final String name;

    Shape(int base, String name) {
        this.base=base;
        this.name=name;
    }
    public int getBase() {
        return this.base;
    }

    public String getName() {
        return name;
    }
}

class Circle extends Shape {


    public Circle(int radius) {
        super(radius, "circle");
    }

    public int getRadius() {
        return getBase();
    }
}

class Square extends Shape{


    public Square(int width) {
        super(width, "square");
    }

    public int getWidth() {
        return getBase();
    }
}


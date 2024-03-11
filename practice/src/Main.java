interface interface1 {
    void foo();
}

class A implements interface1 {
    public void foo() { //must be public
        System.out.println("A class foo method");
    }
}

class B extends A {
    @Override
    public void foo() { //must be public
        super.foo();

        System.out.println("B class foo method");
        super.foo();
    }
}

class Outer {
    Outer() {

        System.out.println(new Inner().private_mod);
        System.out.println(new Inner().package_mod);
        System.out.println(new Inner().protected_mod);
        System.out.println(new Inner().public_mod);

        System.out.println(new InnerStatic().private_mod);
        System.out.println(new InnerStatic().package_mod);
        System.out.println(new InnerStatic().protected_mod);
        System.out.println(new InnerStatic().public_mod);


    }

    public void foo() {
        System.out.println("Outer class private method");
    }

    class Inner {
        int package_mod = 10;
        private int private_mod = 20;
        public int public_mod = 30;
        protected int protected_mod = 40;

        void show() {
            System.out.println("Inner class method");
        }
    }

    static class InnerStatic {
        int package_mod = 10;
        private int private_mod = 20;
        public int public_mod = 30;
        protected int protected_mod = 40;

        void show() {
            System.out.println("Inner static class method");
        }
    }

}

// the format of strategy pattern is:
// 1. an interface that will be implemented by the concrete classes
// 2. a concrete class that will implement the interface
// 3. a class that will use the concrete class
interface Strategy {
    void execute();
}

class ConcreteStrategy1 implements Strategy {
    @Override
    public void execute() {
        System.out.println("ConcreteStrategy1 method");
    }
}

class ConcreteStrategy2 implements Strategy {
    @Override
    public void execute() {
        System.out.println("ConcreteStrategy2 method");
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        strategy.execute();
    }

    int x = 1;
}

abstract class abstractClass {
    private final int x;

    abstractClass() {
        x = 10;
    }

    abstract void foo1();

    void foo2() {
        System.out.println("abstract foo2 method");
    }
}

class concreteClass extends abstractClass {
    concreteClass() {
        super();
    }

    @Override
    void foo1() {
        System.out.println("abstract foo1 method");
    }
}

class shadowingClass {
    int x = 10;

    void foo() {
        System.out.println("shadowing class");
        int x = 20;
        System.out.println(x);
        System.out.println(this.x);
    }

    static void staticFoo() {
        System.out.println("static method");
    }
}

class shadowingClass2 extends shadowingClass {
    int x = 30;

    void foo() {
        System.out.println("shadowing class 2");
        int x = 40;
        System.out.println(x);
        System.out.println(this.x);
        System.out.println(super.x);
    }

    static void staticFoo() {
        System.out.println("static method 2");
    }
}

public class Main {
    public static void main(String[] args) {



        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        Outer.InnerStatic innerStatic = new Outer.InnerStatic();
        innerStatic.show();
//        Outer.Inner innerStatic1 = new Outer.Inner(); not possible because inner class is not static and
//        it is not possible to create an instance of inner class without creating an instance of outer class



        A a = new B();
        a.foo();
        concreteClass c = new concreteClass();
        c.foo1();
        c.foo2();



        shadowingClass s = new shadowingClass2();
        s.foo();
        s.staticFoo();
        shadowingClass.staticFoo();
        System.out.println(s.x); // s is of type shadowingClass2, so it will print 30
        System.out.println(((shadowingClass) s).x); // s is of type shadowingClass2, but we are casting it to shadowingClass, so it will print 10
    }
}
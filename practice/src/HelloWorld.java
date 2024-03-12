public class HelloWorld {
    static class A {
        void f() {
            System.out.println("A");
        }
    }

    static class B extends A {
        void f() {
            System.out.println("B");
        }
    }

    static class C {
        void func(B b) {
            b.f();
        }
    }

    static class D extends C {
        void func(A a) {
            a.f();
        }
    }

    public static void main(String args[]) {
        ((C) (new D())).func(new B());

    }
}
package week4;

/**
 * Created by dot on 25/4/20 11:05 PM
 * Package: week4
 */
class A {
    public void method() {
        System.out.println("Inside A's method");
    }
}
class B extends A {
    public void method() {
        System.out.println("Inside B's method");
    }
}

class C extends A {
    public void method() {
        System.out.println("Inside C's method");
    }
}

public class RunTimePolymorphism {
    public static void main(String args[]) {
        A a = new A();
        A b = new B();
        A c = new C();

        a.method(); //Inside A's method

        b.method(); //Inside B's method

        c.method(); //Inside C's method
    }
}

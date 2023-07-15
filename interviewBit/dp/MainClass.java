package dp;

import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
    void method() throws IOException {

    }
}

class Child extends Parent {
    @Override
    void method() {

    }
}

class Child1 extends Parent {
    @Override
    void method() throws FileNotFoundException {
    }
}

class Child2 extends Parent {
    @Override
    void method() throws IOException {
    }
}

class Child3 extends Parent {
/*
    @Override
    void method() throws Exception {
        // error as Exception is superclass to IOException
    }
*/
}

public class MainClass {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("ef");
        StringBuilder str1 = new StringBuilder("ef");

        System.out.println(str == str1);
        System.out.println(str.equals(str1));
    }
}

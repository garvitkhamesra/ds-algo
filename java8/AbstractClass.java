abstract class AbstractParentClass {

    abstract void someFunction();

    void someOtherMethod() {
        System.out.println("someOtherMethod");
    }
}

public class AbstractClass extends AbstractParentClass {

    @Override
    void someFunction() {

    }

//    void someOtherMethod() {
//        System.out.println("someOtherMethod Child");
//    }

    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractClass();
        abstractClass.someFunction();
        abstractClass.someOtherMethod();
        // if you comment it out then it will call parent but if you un comment it, it will call child
    }
}



abstract class AbstractParentClassWithVariable {

    int someVariable;
    String someStringVariable;

    abstract void someFunction();

    public AbstractParentClassWithVariable(int someVariable, String someStringVariable) {
        this.someVariable = someVariable;
        this.someStringVariable = someStringVariable;
    }

    void print() {
        System.out.println(someVariable + someStringVariable);
    }
}

class AbstractChildClassWithVariable extends AbstractParentClassWithVariable {

    int someVariable;
    String someStringVariable;
    public AbstractChildClassWithVariable(int someVariable, String someStringVariable) {
        super(someVariable, someStringVariable);
        this.someVariable = someVariable;
        this.someStringVariable = someStringVariable;
    }

    @Override
    void someFunction() {
        System.out.println(someVariable + someStringVariable);
    }
}

class AbstractChildClass2WithVariable extends AbstractParentClassWithVariable {

    public AbstractChildClass2WithVariable(int someVariable, String someStringVariable) {
        super(someVariable, someStringVariable);
    }

    @Override
    void someFunction() {
        System.out.println(someVariable + someStringVariable);
    }
}

public class AbstractClassWithVariables {

    public static void main(String[] args) {
        AbstractParentClass abstractClass;
        AbstractParentClassWithVariable abstractChildClassWithVariable =
                new AbstractChildClassWithVariable(1, "2");
        AbstractChildClass2WithVariable abstractChildClass2WithVariable =
                new AbstractChildClass2WithVariable(2, "2");

        abstractChildClassWithVariable.print();
        abstractChildClassWithVariable.someFunction();
        abstractChildClass2WithVariable.print();
    }

//    https://www.java-samples.com/showtutorial.php?tutorialid=288
}



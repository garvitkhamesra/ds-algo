package hard;


class Parent {
     Parent parentMethod() {
        System.out.println("Parent Method");
        return new Parent();
    }
}

class Child extends Parent {
     Child parentMethod() {
        System.out.println("Child Method");
        return new Child();
    }

    public static void main(String[] args) {
        Parent parent = new Parent();
        Parent child = new Child();
        Child child1 = new Child();

        parent.parentMethod();
        child.parentMethod();
        child1.parentMethod();
    }
}
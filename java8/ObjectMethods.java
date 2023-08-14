public class ObjectMethods {
    int key;
    String value;

    public ObjectMethods(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static void main(String[] args) {
        ObjectMethods obj1 = new ObjectMethods(1, "G");
        ObjectMethods obj2 = new ObjectMethods(1, "G");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        ObjectMethods obj3 = new ObjectMethods(2, "G");
        ObjectMethods obj4 = obj3;

        System.out.println(obj3.equals(obj4));
        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());
    }
}

import java.util.Objects;

public class ObjectMethodsOverrides {
    int key;
    String value;

    public ObjectMethodsOverrides(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectMethodsOverrides that = (ObjectMethodsOverrides) o;
        return key == that.key && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public static void main(String[] args) {
        ObjectMethodsOverrides obj1 = new ObjectMethodsOverrides(1, "G");
        ObjectMethodsOverrides obj2 = new ObjectMethodsOverrides(1, "G");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        ObjectMethodsOverrides obj3 = new ObjectMethodsOverrides(2, "G");
        ObjectMethodsOverrides obj4 = obj3;

        System.out.println(obj3.equals(obj4));
        System.out.println(obj3.hashCode());
        System.out.println(obj4.hashCode());

        /*
            Answers from Object Methods class
            false
            356573597
            1735600054
            21685669
            2133927002
        */
    }
}

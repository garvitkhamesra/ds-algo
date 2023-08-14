import java.util.Objects;

public class HashcodeOverride {
    int key;
    String value;

    public HashcodeOverride(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public static void main(String[] args) {
        HashcodeOverride obj1 = new HashcodeOverride(1, "G");
        HashcodeOverride obj2 = new HashcodeOverride(1, "G");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        HashcodeOverride obj3 = new HashcodeOverride(2, "G");
        HashcodeOverride obj4 = obj3;

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

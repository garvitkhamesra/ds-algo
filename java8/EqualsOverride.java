import java.util.Objects;

public class EqualsOverride {
    int key;
    String value;

    public EqualsOverride(int key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsOverride that = (EqualsOverride) o;
        return key == that.key && Objects.equals(value, that.value);
    }

    public static void main(String[] args) {
        EqualsOverride obj1 = new EqualsOverride(1, "G");
        EqualsOverride obj2 = new EqualsOverride(1, "G");

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        EqualsOverride obj3 = new EqualsOverride(2, "G");
        EqualsOverride obj4 = obj3;

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

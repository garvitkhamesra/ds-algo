package week3.invideo;

/**
 * Created by dot on 23/4/20 10:02 PM
 * Package: week3.invideo
 */
public class Test {
    public static void main(String[] args) {
        Double object = new Double("2.4");
        int a = object.intValue();
        System.out.println(a );

        byte b = object.byteValue();
        System.out.println(b );
        float d = object.floatValue();
        System.out.println(d);

        double c = object.doubleValue();
        System.out.println(c);


        System.out.println(a + b + c + d );

    }
}

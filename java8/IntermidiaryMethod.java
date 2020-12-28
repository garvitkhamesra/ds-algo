import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermidiaryMethod {
    //Lazy methods of stream;
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> p1 = s1 -> s1.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        List<String> result = new ArrayList<>();

        /*
        This call is like declaration nothing will happen because all the functions are lazy
        as they return stream as the result on the other hand the next is foreach which does not return anything

        stream
                .peek(System.out::println)
                .filter(p1.or(p2).or(p3))
                .peek(result::add);

        */

        stream
                .peek(System.out::println)
                .filter(p1.or(p2).or(p3))
                .forEach(result::add);

        System.out.println("Done processing. size of result -> " + result.size());
    }
}

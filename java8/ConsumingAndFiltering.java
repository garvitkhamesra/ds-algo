import java.util.function.Predicate;
import java.util.stream.Stream;

public class ConsumingAndFiltering {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");
        //stream.forEach(System.out::println);
        Predicate<String> p1 = s1 -> s1.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        stream.filter(p1.or(p2).or(p3)).forEach(System.out::println);
    }
}

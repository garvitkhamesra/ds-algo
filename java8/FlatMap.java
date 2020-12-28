import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        List<Integer> list3 = Arrays.asList(1, 3, 5, 7);
        List<List<Integer>> list = Arrays.asList(list1, list2, list3);

        Function<List<?>, Integer> size = List::size; // l -> l.size()
        Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();

        System.out.println("Map with size");
        list.stream()
                .map(size)
                .forEach(System.out::println);

        System.out.println("Flatmap, so every list is producing list of stream from the flatMapper function" +
                " and it has flattened it");
        list.stream()
                .flatMap(flatMapper)
                .forEach(System.out::println);

        System.out.println("Map, so every list is producing list of stream from the flatMapper function " +
                "and it has produced a stream without changing anything");
        list.stream()
                .map(flatMapper)
                .forEach(System.out::println);
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduction {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList();

        System.out.println("For value 1 result will be 1, -1 -> 0," +
                " (-1, -11) -> 0(which is wrong so in this case we use optional) and in case of empty -> 0");
        Integer result = list.stream()
                .reduce(0, Integer::max);
        System.out.println(result + "\n");

        System.out.println("For value 1 result will be 1, -1 -> -1, (-1, -11) -> -1, empty -> empty");
        Optional<Integer> optionalResult = list.stream()
                .reduce(Integer::max);
        System.out.println(optionalResult);
    }
}

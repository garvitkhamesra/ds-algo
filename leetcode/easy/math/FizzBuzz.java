package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 10/1/20 9:47 PM
 * Package: math
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 && i%5==0) {
                list.add("FizzBuzz");
            } else if (i%3 == 0) {
                list.add("Fizz");
            } else if (i%5==0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}

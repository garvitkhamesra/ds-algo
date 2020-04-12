import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 12/4/20 9:54 AM
 * Package: PACKAGE_NAME
 */
public class QueryPermutation {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> p = new ArrayList<Integer>();
        int [] res = new int[queries.length];
        for (int i = 0; i < m; i++) {
            p.add(i+1);
        }

        for (int i = 0; i < queries.length; i++) {
            int temp = queries[i];
            res[i] = p.indexOf(temp);
            p.remove(res[i]);
            p.add(0, temp);
        }

        return res;
    }
}

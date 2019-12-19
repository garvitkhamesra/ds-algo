package level2;

import java.util.ArrayList;
import java.util.List;

/**
 * User: garvit
 * Date: 27/09/19 11:12 AM
 */
public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int t = 0 , r = A.get(0).size()-1, l = 0, b = A.size()-1;
        int dir = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (t <= b && l <= r) {
            if (dir == 0) {
                for (int i = l; i <= r; i++) {
                    result.add(A.get(t).get(i));
                }
                t++;
                dir = 1;
            }
            else if (dir == 1) {
                for (int i = t; i <= b; i++) {
                    result.add(A.get(i).get(r));
                }
                r--;
                dir = 2;
            }
            else if (dir == 2) {
                for (int i = r; i >= l; i--) {
                    result.add(A.get(b).get(i));
                }
                b--;
                dir = 3;
            }
            else if (dir == 3) {
                for (int i = b; i >= t; i--) {
                    result.add(A.get(i).get(l));
                }
                l++;
                dir = 0;
            }
        }

        return result;
    }
}

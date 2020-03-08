/**
 * Created by dot on 8/3/20 4:35 PM
 * Package: PACKAGE_NAME
 */
public class BlueBulbs {
    public int numTimesAllBlue(int[] A) {
        int right = 0, res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            right = Math.max(right, A[i]);
            if (right == i + 1) ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        BlueBulbs blueBulbs = new BlueBulbs();
        blueBulbs.numTimesAllBlue(new int[] {4,1,2,3});
    }
}

/**
 * Created by dot on 18/4/20 10:19 AM
 * Package: PACKAGE_NAME
 */
public class FindCeleb {
     /*
     *  So in the question there is an api which will tell that the person
     *  knows the other person or not.
     *  Celebrity is who does not know anyone but everyone knows him;
     *
     * */

    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i)) {
                celebrity = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if ((i != celebrity && knows(celebrity, i)) || !knows(i, celebrity)) {
                return -1;
                // Celebrity not found
            }
        }
        return celebrity;
    }

    public static boolean knows(int person1, int person2) {
        /*
        * As we don't have the questions API
        * */
        return true;
    }
}

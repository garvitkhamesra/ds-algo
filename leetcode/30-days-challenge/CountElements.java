import java.util.HashSet;

/**
 * Created by dot on 7/4/20 7:32 PM
 * Package: PACKAGE_NAME
 */
public class CountElements {
    public int countElements(int[] arr) {
        int count = 0, frequency = 1;


         /*1
             st Approach
             Complexity -  O(N^2)
         */

         /*for (int i = 0; i < arr.length; i++) {
             for (int j = 0; j < arr.length; j++) {
                 if(arr[i] + 1 == arr[j]) {
                     count++;
                     break;
                 }
             }
         }*/

         /*
             2nd Approach
             Complexity -  O(NLOGN)
         */

         /*Arrays.sort(arr);

         for (int i = 0; i < arr.length - 1; i++) {
             if (arr[i] == arr[i+1]) {
                 frequency++;
             } else {
                 if(arr[i] + 1 == arr[i+1]) {
                     count+= frequency;
                 }
                                     frequency = 1;

             }
         }*/


        /*
            3rd Approach
            Complexity -  O(N)
        */

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1)) count++;
        }

        return count;
    }
}

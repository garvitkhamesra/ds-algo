/**
 * User: garvit
 * Date: 22/02/21 6:20 PM
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        // int[] temp = Arrays.copyOf(heights, heights.length);
        // Arrays.sort(heights);
        // int res = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     if (heights[i] != temp[i]) res++;
        // }
        // return res;

        // Implementing with count sort approach
        int res = 0;
        int[] freq = new int[101];
        for (int i = 0; i < heights.length; i++) {
            freq[heights[i]]++;
        }
        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i-1];
        }
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != heights[freq[heights[i] - 1]]) res++;
            freq[heights[i]]--;
        }
        return res;
    }
}

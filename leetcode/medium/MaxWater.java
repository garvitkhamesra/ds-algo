public class MaxWater {
    public int maxArea(int[] height) {
        int ans = 0, i = 0, j = height.length - 1;
        while (i < height.length && j >= 0) {
            ans = Math.max(ans, (j-i) * Math.min(height[j], height[i]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}

package top150interview;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int c = 0, res = -1;
        for (int num : nums) {
            if (c == 0) {
                res = num;
            }
            c += (num == res) ? 1 : -1;
        }
        return res;
    }
}

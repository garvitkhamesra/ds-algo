package top150interview;

public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        int i = 2, c = 1;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] == nums[i-1]) {
                c++;
            } else {
                c =1;
            }

            if (c <=2) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public int removeDuplicates2(int[] nums) {
        int x = 2;
        for(int i = x; i < nums.length; i++) {
            if(nums[i] != nums[x - 2]) {
                nums[x++] = nums[i];
            }
        }
        return x;
    }

    public int removeDuplicatesSingle(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i-1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}

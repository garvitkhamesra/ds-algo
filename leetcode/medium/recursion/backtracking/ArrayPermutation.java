package medium.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length, result);
        return result;
    }

    private void permute(int[] nums, int start, int end, List<List<Integer>> result) {
        if (start == end) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < end; i++) {
            swap(nums, i, start);
            permute(nums, start+1, end, result);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {1,2,3,4};
        ArrayPermutation arrayPermutation = new ArrayPermutation();
        List<List<Integer>> permute = arrayPermutation.permute(nums);
        System.out.println(permute.size());

        for (List list : permute) {
            System.out.println(list);
        }
    }
}

package arrays;

import java.util.Arrays;

public class FourSum {
    static int[] findArrayQuadruplet(int[] arr, int target) {
        if (arr.length < 4) return new int[]{};
        Arrays.sort(arr);
        boolean flag = true;
        for(int i=0; i<arr.length-3; i++){
            for(int j=i+1; j<arr.length-2; j++){
                int left = j+1;
                int right = arr.length-1;

                while(left<right){
                    int sum = arr[i]+arr[j]+arr[left]+arr[right];
                    if(sum == target) {
                        return new int[] {arr[i], arr[j], arr[left], arr[right]};
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findArrayQuadruplet(new int[] {2,7,4,0,9,5,1,3}, 20)));
    }

}

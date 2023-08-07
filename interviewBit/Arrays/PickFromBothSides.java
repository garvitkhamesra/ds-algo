package Arrays;

public class PickFromBothSides {
    public int solve(int[] a, int b) {
        int n=a.length, curSum=0;

        for(int i=0; i<b; i++) {
            curSum+=a[i];
        }

        int maxSum=curSum;

        for(int i=b-1; i>=0; i--) {
            curSum+=a[i+(n-b)]-a[i];
            maxSum=(curSum>maxSum)?curSum:maxSum;
        }
        return maxSum;
    }
}

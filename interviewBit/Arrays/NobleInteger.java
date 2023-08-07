package Arrays;

import java.util.Arrays;

public class NobleInteger {
    public int solve(int[] A) {
        Arrays.sort(A);
        int c=0,n=A.length-1;
        if(A[n]==0) return 1;
        for(int i =0;i<n;i++){
            if(A[i+1]>A[i]){
                c = n-i;
                if(A[i]==c) return 1;
            }
        }
        return -1;
    }
}

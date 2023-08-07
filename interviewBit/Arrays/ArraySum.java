package Arrays;

public class ArraySum {
    public int[] addArrays(int[] A, int[] B) {
        int arr[] = new int[Math.max(A.length,B.length)];
        int k = arr.length-1;
        int carry = 0;
        for(int i=A.length-1,j = B.length-1;i>=0 || j>=0;i--,j--){
            if(i < 0) arr[k] = B[j]+carry;
            else if(j < 0 ) arr[k] = A[i]+carry;
            else arr[k] = A[i]+B[j]+carry;
            carry = arr[k]/10;
            if(arr[k]>9) arr[k] = arr[k]%10;
            k--;
        }
        if(carry > 0 ){
            int brr[] = new int[arr.length+1];
            brr[0] = carry;
            System.arraycopy(arr, 0, brr, 1, arr.length);
            return brr;
        }
        return arr;
    }
}




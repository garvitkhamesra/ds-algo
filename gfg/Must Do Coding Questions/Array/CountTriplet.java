package Array;

import java.util.Arrays;

public class CountTriplet {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int res = 0, k = n-1;
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (binarySearch(arr, j+1, n-1, (arr[i] + arr[j])) != -1) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int binarySearch(int arr[], int first, int last, int key){
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid] < key ){
                first = mid + 1;
            }else if ( arr[mid] == key ){
                return mid;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }

        return -1;

    }
}
package Array;

public class MissingNumberInArray {
    int MissingNumber(int array[], int n) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        int aSum = (n * (n+1))/2;
        return aSum - sum;
    }
}

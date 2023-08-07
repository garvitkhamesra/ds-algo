package String;

public class AmazingSubarrays {
    public int solve(String A) {
        int count = 0;
        char arr[] = A.toCharArray();
        int n = arr.length;
        for(int i=0; i<n; i++)
        {
            arr[i] = Character.toUpperCase(arr[i]);
            if(arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U')
            {
                count += (n - i);
            }
        }
        return count % 10003;
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = new int[] {1, 3, 4, 6, 7, 8};
        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.binarySearch(arr, 0, arr.length, 5);
        System.out.println(search);
    }

    public int binarySearch (int arr[], int l, int r, int x) {
        if (l < r) {
            int midIndex = (l + r) / 2;
            int mid = arr[midIndex];
            if (mid > x) return binarySearch(arr, 0, midIndex - 1, x);
            else if (mid < x) return binarySearch(arr, midIndex + 1, r, x);
            else return midIndex;
        } else return -1;
    }
}

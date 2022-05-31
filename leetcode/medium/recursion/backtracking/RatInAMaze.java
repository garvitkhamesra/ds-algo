package medium.recursion.backtracking;

import java.util.ArrayList;

public class RatInAMaze {

    public static void main(String[] args) {
        int n = 4;
        int[][] a = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};

        ArrayList< String > res = findPath(a, n);
        if (res.size() > 0) {
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static ArrayList<String> findPath(int[][] arr, int n) {
        int visited[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
        ArrayList < String > ans = new ArrayList < > ();

        if (arr[0][0] == 1) {
            findPathHelper(arr, n, 0, 0, ans, "", visited);
        }
        return ans;
    }

    private static void findPathHelper(int[][] arr, int n, int i, int j, ArrayList<String> ans, String path, int[][] visited) {
        if (i == n-1 && j == n-1) {
            ans.add(path);
            return;
        }

        if (visited[i][j] == 1 || arr[i][j] != 1) {
            return;
        }

        visited[i][j] = 1;

        if (i >= 0 && i + 1 < n && arr[i+1][j] == 1 && visited[i+1][j] != 1) {
            findPathHelper(arr, n, i+1, j, ans, path + "D", visited);
        }

        if (i - 1 >= 0 && i < n && arr[i-1][j] == 1 && visited[i-1][j] != 1) {
            findPathHelper(arr, n, i-1, j, ans, path + "U", visited);
        }

        if (j >= 0 && j+1 < n && arr[i][j+1] == 1 && visited[i][j+1] != 1) {
            findPathHelper(arr, n, i, j+1, ans, path + "R", visited);
        }

        if (j-1 >= 0 && j < n && arr[i][j-1] == 1 && visited[i][j-1] != 1) {
            findPathHelper(arr, n, i, j-1, ans, path + "L", visited);
        }

        visited[i][j] = 0;
    }
}
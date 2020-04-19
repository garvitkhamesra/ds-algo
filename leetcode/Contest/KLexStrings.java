import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 19/4/20 12:12 PM
 * Package: PACKAGE_NAME
 */

/*
* https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
* */
public class KLexStrings {
    public String getHappyString(int n, int k) {
        char[] arr = {'a', 'b', 'c'};
        String res="";
        List<String> l=new ArrayList<>();
        generatePerm(arr, n, res, l);
        if(l.size() >= k)
            res=l.get(k-1);
        return res;
    }

    private void generatePerm(char[] arr, int n, String res, List<String> l){
        if(n == 0){
            l.add(res);
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(res == "" || res.charAt(res.length()-1) != arr[i]){
                String pre=res+arr[i];
                generatePerm(arr, n-1, pre, l);
            }
        }

    }
}

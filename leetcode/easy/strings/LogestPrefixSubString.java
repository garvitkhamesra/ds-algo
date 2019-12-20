package easy.strings;

/**
 * User: garvit
 * Date: 20/12/19 6:10 AM
 */

/*
Longest Common Prefix
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
*/

public class LogestPrefixSubString {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        else if (strs.length == 1) return strs[0];

        String prefix  = "";
        String temp = "";
        for (int i = 0; i < strs[0].length(); i++) {
            temp += strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i+1 > strs[j].length() || !temp.equals(strs[j].substring(0, i+1))) {
                    return prefix;
                } else if (i+1 <= strs[j].length() && temp.equals(strs[j].substring(0, i+1)) &&
                        j == strs.length-1) {
                    prefix = temp;
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] arr = new String[3];
        arr[0] = "aaa";
        arr[1] = "aa";
        arr[2] = "aaa";

        LogestPrefixSubString logestPrefixSubString = new LogestPrefixSubString();
        logestPrefixSubString.longestCommonPrefix(arr);
    }
}

/*
Other Solutions
1. Nice code, do less work
if (strs.length<1) return "";
int n=strs[0].length();
for (int j=1;j<strs.length;j++){
    n = Math.min(n,strs[j].length());
    for(int i=0; i<n;i++){
        if(strs[j].charAt(i)!=strs[0].charAt(i)){ n=i;break;}}
}
return strs[0].substring(0,n);

2. finding the smallest string first
public String longestCommonPrefix(String[] strs) {
    if (strs.length < 1 || strs == null) {
        return "";
    }
    if (strs.length == 1) {
        return strs[0];
    }
    //find the shortest String
    int shortest = 0;
    int len = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
        int curLen = strs[i].length();
        if (curLen < len) {
            len = curLen;
            shortest = i;
        }
    }
    //find the longest common prefix
    String sub = strs[shortest];
    for (int i = 0; i < strs.length; i++) {
        while (strs[i].indexOf(sub) != 0) {
            sub = sub.substring(0, sub.length()-1);
        }
    }
    return sub;
}

3. Horizontal scanning
public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    return prefix;
}

4. Vertical Scanning
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);
        }
    }
    return strs[0];
}

5. Divide and Conquer
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
}

private String longestCommonPrefix(String[] strs, int l, int r) {
    if (l == r) {
        return strs[l];
    }
    else {
        int mid = (l + r)/2;
        String lcpLeft =   longestCommonPrefix(strs, l , mid);
        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
        return commonPrefix(lcpLeft, lcpRight);
   }
}

String commonPrefix(String left,String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++) {
        if ( left.charAt(i) != right.charAt(i) )
            return left.substring(0, i);
    }
    return left.substring(0, min);
}


*/

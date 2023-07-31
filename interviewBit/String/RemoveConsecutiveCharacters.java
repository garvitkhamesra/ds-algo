package String;

public class RemoveConsecutiveCharacters {
    public String solve(String s, int b) {
        int i=0, j = 0;
        s = s+'$';
        String ans = "";
        int count = 0;
        while(j<s.length()){
            if (s.charAt(i) == s.charAt(j) ){
                count++;
                j++;
            } else{
                if (count != b){
                    ans += s.substring(i,j);
                }
                i=j;count=0;
            }

        }
        return ans;
    }
}

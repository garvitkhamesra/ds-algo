package String;

public class BullsAndCows {
    public String solve(String A, String B) {
        int a[] = new int[10];
        int b[] = new int[10];
        int x=0,y=0;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)==B.charAt(i))
                x++;
            else
            {
                a[A.charAt(i)-'0']++;
                b[B.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<a.length;i++)
        {
            y += Math.min(a[i],b[i]);
        }
        return x+"A"+y+"B";
    }
}

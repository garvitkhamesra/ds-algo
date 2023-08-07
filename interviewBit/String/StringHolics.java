package String;

import java.util.ArrayList;
import java.util.Arrays;

public class StringHolics {

    public int solve(ArrayList<String> A) {

        int rotation[]=new int[A.size()];

        for(int i=0;i<A.size();i++){
            String s=A.get(i);
            int n=s.length();
            int temp[]=new int[s.length()];

            kmp(s,temp);

            //  for(int j=0;j<temp.length;j++)
            //  System.out.print(temp[j]+" ");

            if(temp[n-1]==0||n%(n-temp[n-1])!=0)
                rotation[i]=(int)get(n);
            else
                rotation[i]=(int)get(n-temp[n-1]);
            // System.out.println();


        }
        //  System.out.println();
        //  for(int j=0;j<rotation.length;j++)
        //          System.out.print(rotation[j]+" ");

        return (int)LCM(rotation);

    }



    public static void kmp(String s,int[] temp){
        int len=0;
        int i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len))
            {
                len++;
                temp[i]=len;
                i++;

            }
            else{
                if(len>0)
                    len=temp[len-1];
                else{
                    len=0;
                    i++;}
            }
        }
    }

    public static long get(int p){
        long x=p*2;
        long i=1;
        for(;i<x;i++){

            if(i*(i+1)%x==0)
                return i;
        }
        return i;
    }
    public static long LCM(int[] r){
        HashMap<Integer,Integer> map=new HashMap<>();


        for(int j=0;j<r.length;j++){
            //System.out.println(r[j]);
            for(int i=2;i*i<=r[j];i++){
                int count=0;

                while(r[j]%i==0){

                    count++;
                    r[j]=r[j]/i;
                }

                if(count>0)
                {if(map.containsKey(i))
                    map.put(i,Math.max(map.get(i),count));

                else
                    map.put(i,count);
                }


            }

            if(r[j]>1){
                if(!map.containsKey(r[j]))
                    map.put(r[j],1);
            }

            // System.out.println(map);
        }
        //  System.out.println(map);
        long x=1;
        int p=(int)1e9+7;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){

            long a= power(entry.getKey(),entry.getValue());
            //System.out.println(a);
            x=(x*a)%p;
        }

        return x;





    }
    static long power(long x, long y)
    {
        long temp;
        if( y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return (temp*temp)%(long)(1e9+7);
        else
            return (x*temp*temp)%(long)(1e9+7);
    }

}

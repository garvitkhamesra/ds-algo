package dp;

public class KPVariation {
    public int solve(final int[] req, final int[] wts, final int[] costs) {
        int cost=0;
        for(int i=0;i<req.length;i++){

            long[] dp=new long[req[i]+1];
            for(int k=1;k<dp.length;k++){
                dp[k]=Integer.MAX_VALUE;
            }
            //dp
            for(int j=1;j<=req[i];j++){
                for(int k=0;k<wts.length;k++){
                    if(wts[k]<=j){
                        dp[j]=Math.min(costs[k]+dp[j-wts[k]],dp[j]);
                    }
                }
            }
            cost+=dp[req[i]];
        }
        return cost;
    }
}

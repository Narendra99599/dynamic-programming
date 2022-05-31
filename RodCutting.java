import java.util.*;
class Solution{
    static int f(int n,int[] arr,int[] dp){
        if(n == 0)
            return 0;
        if(dp[n] != -1) 
            return dp[n];
        int a = -(int)1e9;
        for(int i=1; i<=n; i++){
            int b = arr[i-1];
            b += f(n-i,arr,dp);
            a = Math.max(a, b);
        }
        return dp[n] = a;
    }
    
    static int f(int n,int[] arr){
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            int a = -(int)1e9;
            for(int j = 1; j<=i; j++){
                int b = arr[j-1] + dp[i-j];
                a = Math.max(a,b);
            }
            dp[i] = a;
        }
        return dp[n];
    }
    
    public int cutRod(int price[], int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,price);
    }
}
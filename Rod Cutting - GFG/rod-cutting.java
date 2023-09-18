//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    Integer[][] dp;
    public int cutRod(int price[], int n) {
        //code here
        dp=new Integer[n+1][n+1];
       return  find(price,n,n);
    }
    public int find(int[] prices,int n,int m){
        if(n==0 || m==0)
           return 0;
        if(dp[n][m]!=null)
           return dp[n][m];
        if(n<=m){
            return dp[n][m]=Math.max(find(prices,n-1,m),find(prices,n,m-n)+prices[n-1]);
        }
        else
           return dp[n][m]=find(prices,n-1,m);
    }
}
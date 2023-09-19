//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    Integer[][] dp;
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int n=str.length();
        dp=new Integer[n+1][n+1];
        return lcs(str,n,n);
    }
    public int lcs(String s,int n,int m){
        if(n==0 || m==0)
           return 0;
        if(dp[n][m]!=null)
           return dp[n][m];
        if(s.charAt(n-1)== s.charAt(m-1) && n!=m)
          return dp[n][m]=1+lcs(s,n-1,m-1);
        else
          return dp[n][m]=Math.max(lcs(s,n-1,m),lcs(s,n,m-1));
    }
}
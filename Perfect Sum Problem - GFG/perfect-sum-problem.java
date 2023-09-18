//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    long mod=(long)Math.pow(10,9)+7;

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    Integer[][] dp=new Integer[n+1][sum+1];
	    return find(arr,n,sum,dp);
	} 
	public int find(int[] arr,int n,int sum,Integer[][] dp){
	    if(n==0){
	        if(sum==0)
	          return 1;
	        return 0;
	    }
	    if(dp[n][sum]!=null)
	      return dp[n][sum];
	    if(arr[n-1]<=sum)
	      return dp[n][sum]=(int)(((find(arr,n-1,sum-arr[n-1],dp))%mod+(find(arr,n-1,sum,dp))%mod)%mod);
	    else
	      return dp[n][sum]=(int)(find(arr,n-1,sum,dp)%mod);
	}
}
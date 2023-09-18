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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int range=0;
	    for(int i=0;i<n;i++)
	      range+=arr[i];
	   Integer[][] dp=new Integer[n+1][range/2+1];
	    return range - 2*find(n,arr,range/2,dp);
	} 
	public int find(int n,int[] arr,int sum,Integer[][] dp){
	    if(n==0 || sum==0)
	      return 0;
	    if(dp[n][sum]!=null)
	      return dp[n][sum];
	    if(arr[n-1]<=sum)
	       return dp[n][sum]=Math.max(find(n-1,arr,sum,dp),find(n-1,arr,sum-arr[n-1],dp)+arr[n-1]);
	   else
	     return dp[n][sum]=find(n-1,arr,sum,dp);
	}
}

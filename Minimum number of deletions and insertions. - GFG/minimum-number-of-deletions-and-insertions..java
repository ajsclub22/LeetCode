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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    Integer[][] dp;
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n=str1.length() ,m=str2.length();
	    dp=new Integer[n+1][m+1];
	    return n+m-2*lcs(str1,str2,n,m);
	} 
	public int lcs(String s1,String s2,int n,int m){
	    if(n==0 || m==0)
	       return 0;
	    if(dp[n][m]!=null)
	      return dp[n][m];
	    if(s1.charAt(n-1)==s2.charAt(m-1))
	      return dp[n][m]=1+lcs(s1,s2,n-1,m-1);
	    else
	      return dp[n][m]=Math.max(lcs(s1,s2,n-1,m),lcs(s1,s2,n,m-1));
	     
	}
}
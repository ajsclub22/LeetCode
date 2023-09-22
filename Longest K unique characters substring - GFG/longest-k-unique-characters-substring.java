//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int K) {
        // code here
        Map<Character,Integer> map=new HashMap<>();
        int maxi=0;
        for(int i=0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                int m=map.get(s.charAt(i));
                map.put(s.charAt(i),++m);
            }
            else
              map.put(s.charAt(i),1);
            if(K==map.size()){
                maxi=Math.max(maxi,i-j+1);
            }
            else if(map.size()>K){
                while(map.size()>K){
                    int m=map.get(s.charAt(j));
                    --m;
                    if(m==0)
                       map.remove(s.charAt(j));
                    else
                       map.put(s.charAt(j),m);
                    j++;
                }
            }
        }
        return maxi;
    }
}
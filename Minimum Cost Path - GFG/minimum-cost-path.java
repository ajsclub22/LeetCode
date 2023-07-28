//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.data-b.data);
        int n=grid.length;
        int m=grid[0].length;
        int[][] d=new int[n][m];
        for(int[] arr:d)
           Arrays.fill(arr,Integer.MAX_VALUE);
        pq.offer(new Tuple(grid[0][0],0,0));
        d[0][0]=grid[0][0];
        int[] dx={0,0,-1,1};
        int[] dy={1,-1,0,0};
        while(!pq.isEmpty()){
            int curr=pq.peek().data;
            int i=pq.peek().i;
            int j=pq.peek().j;
            pq.poll();
            for(int k=0;k<4;k++){
                int r=i+dx[k];
                int c=j+dy[k];
                if(r>=0 && c>=0 && r<n && c<m ){
                    if(d[r][c]>curr+grid[r][c]){
                      pq.offer(new Tuple(curr+grid[r][c],r,c));
                      d[r][c]=curr+grid[r][c];
                    }
                }
            }
        }
        return d[n-1][m-1];
    }
}
class Tuple{
    int data,i,j;
    Tuple(int d,int r,int c){
        data=d;
        i=r;
        j=c;
    }
}
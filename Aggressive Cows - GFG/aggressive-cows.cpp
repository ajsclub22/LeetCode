//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
public:

    int canDo(vector<int> &stalls,int k,int mid){
        int n = stalls.size();
        int f = stalls[0];
        int cnt = 1;
        for(int i = 1;i < n;i++){
            if(stalls[i] -f >= mid){
                cnt++;
                f = stalls[i];
            }
            if(cnt == k) return 1;
        }
        return 0;
    }

    int solve(int n, int k, vector<int> &stalls) {
        int low = 0,high = 0;
        int ans;
        sort(stalls.begin(),stalls.end());
        high = stalls[n-1] - stalls[0];
        low = 1;
        while(low <= high){
            int mid = low + (high -low)/2;
            int flag = canDo(stalls,k,mid);
            if(flag){
                low = mid + 1;
                ans = mid;
            }
            else{
                high = mid -1;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t = 1;
    cin >> t;

    // freopen ("output_gfg.txt", "w", stdout);

    while (t--) {
        // Input

        int n, k;
        cin >> n >> k;

        vector<int> stalls(n);
        for (int i = 0; i < n; i++) {
            cin >> stalls[i];
        }
        // char ch;
        // cin >> ch;

        Solution obj;
        cout << obj.solve(n, k, stalls) << endl;

        // cout << "~\n";
    }
    // fclose(stdout);

    return 0;
}
// } Driver Code Ends
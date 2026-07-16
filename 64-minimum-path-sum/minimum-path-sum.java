class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,grid,dp);
    }
    int helper(int row,int col,int[][] grid,int[][] dp){
         int n=grid.length;
        int m=grid[0].length;
        if(row==n-1&&col==m-1){
            return grid[row][col];
        }
        if(row>n-1||col>m-1){
            return Integer.MAX_VALUE;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
      int right = helper(row, col + 1, grid, dp);
int down = helper(row + 1, col, grid, dp);

int ans = Integer.MAX_VALUE;

if (right != Integer.MAX_VALUE)
    ans = Math.min(ans, grid[row][col] + right);

if (down != Integer.MAX_VALUE)
    ans = Math.min(ans, grid[row][col] + down);

return dp[row][col] = ans;
        
    }
}
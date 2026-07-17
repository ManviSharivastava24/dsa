class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&vis[i][j]==0){
                    count++;
                    dfs(i,j,grid,vis);
                }
            }
        }
return count;
    }
     public void dfs(int i,int j,char[][] grid, int vis[][]){
         int n=grid.length;
        int m=grid[0].length;
    if(i<0||j<0||i>=n||j>=m||grid[i][j]=='0'){
        return ;
    }
    vis[i][j]=1;
    grid[i][j]='0';
    dfs(i+1,j,grid,vis);
    dfs(i,j+1,grid,vis);
    dfs(i-1,j,grid,vis);
    dfs(i,j-1,grid,vis);
 }
}
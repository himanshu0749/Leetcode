class Solution {
    void dfs(int[][] grid,int i,int j,boolean[][] visit){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visit[i][j] || grid[i][j]==0) return;
        visit[i][j]=true; // mark visit
        dfs(grid,i+1,j,visit);
        dfs(grid,i-1,j,visit);
        dfs(grid,i,j+1,visit);
        dfs(grid,i,j-1,visit);
    }
    private int countIsland(int[][] grid){
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        int isLands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visit[i][j]){
                    isLands++;
                    dfs(grid,i,j,visit);
                }
            }
        }
        return isLands;
    }
    public int minDays(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        //int island=countIsland(grid);
        if (countIsland(grid) != 1) return 0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0; //convert water
                    //island=countIsland(grid);
                    if (countIsland(grid) != 1) return 1;
                    grid[i][j]=1;
                } 
            }
        }
        return 2;
    }
}

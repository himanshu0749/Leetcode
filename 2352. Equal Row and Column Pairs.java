class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length-1;
        int c=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                boolean eq=true;
                for(int k=0;k<=n;k++){
                    if(grid[i][k]!=grid[k][j]) {
                        eq=false;
                        break;
                    }
                }
                if(eq){
                    c++;
                }
            }
        }
        return c;
    }
}

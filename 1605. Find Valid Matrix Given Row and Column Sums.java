class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n=rowSum.length;
        int m=colSum.length;
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int mini=Math.min(rowSum[i],colSum[j]);
                mat[i][j]=mini;
                rowSum[i]=rowSum[i]-mini;
                colSum[j]=colSum[j]-mini;
            }
        }
        return mat;
    }
}

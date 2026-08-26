class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0;
        int col=m-1;
        while(row<=n-1 && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]>target){
                //move left
                col--;
            }
            else{
                //move down
                row++;
            }
        }
        return false;
    }
}
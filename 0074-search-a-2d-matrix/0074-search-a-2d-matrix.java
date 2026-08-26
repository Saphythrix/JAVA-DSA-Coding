class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int low=0,res=0;
        int high=rows-1;
        while(high>=low){
            int guess=(high+low)/2;
            if(target>=matrix[guess][0]){
                res=guess;
                low=guess+1;
                
            }else{
                high=guess-1;
            }
        }
        low=0;
        high=cols-1;
        while(high>=low){
            int guess=(high+low)/2;
            if(matrix[res][guess]==target){
                return true;
            }
            else if(matrix[res][guess]>target){
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return false;
    }
}
class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int low=0,high=n-1,res=-1;
        while(high>=low){
            int guess=(high+low)/2;
            if(arr[guess]>arr[n-1])//part 2-move right
            {
                low=guess+1;
                
            }
            else{//part 1:- find the first occurance
                res=arr[guess];
                high=guess-1;
            }
        }
        return res;
    }
}
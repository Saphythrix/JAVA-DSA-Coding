class Solution {
    public int firstOccurance(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int res=-1;
        while(high>=low){
            int guess=(high+low)/2;
            if(arr[guess]<target){
                low=guess+1;
            }
            else if(arr[guess]>target){
                high=guess-1;
            }
            else{
                res=guess;
                high=guess-1;
            }
           
        }
         return res;
    }
     public int lastOccurance(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int res=-1;
        while(high>=low){
            int guess=(high+low)/2;
            if(arr[guess]<target){
                low=guess+1;
            }
            else if(arr[guess]>target){
                high=guess-1;
            }
            else{
                res=guess;
                low=guess+1;
            }
           
        }
         return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int first=firstOccurance(nums,target);
        int last=lastOccurance(nums,target);
        return new int[]{first,last};
        
    }
}
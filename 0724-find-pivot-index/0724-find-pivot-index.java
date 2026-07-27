class Solution {
    public int pivotIndex(int[] arr) {
        int n=arr.length;
        int sum=0,left=0,right=0,c=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        for(int i=0;i<n;i++){
            right=sum-left-arr[i];
            if(left==right){
                return i;
            }
            left+=arr[i];
            
        }
        return -1;
    }
}
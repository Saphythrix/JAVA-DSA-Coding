class Solution {
    public boolean distributeCandies(int arr[],long k,int guess){
        long c=0;
        for(int i=0;i<arr.length;i++){
            int div=arr[i]/guess;
            c+=div;
        }
        if(c>=k){
            return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int maxCandies=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            maxCandies=Math.max(maxCandies,candies[i]);
        }
        int low=1;
        int high=maxCandies;
        int res=0;
        while(high>=low){
            int guess=(high+low)/2;
            if(distributeCandies(candies,k,guess)){
                res=guess;
                low=guess+1;
            }else{
                high=guess-1;
            }
        }
        return res;
    }
}
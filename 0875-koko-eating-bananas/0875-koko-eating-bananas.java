class Solution {
    public long findHrs(int piles[],int k){// helper function
        int n=piles.length;
        long hrs=0;
        for(int i=0;i<n;i++){
            hrs+=piles[i]/k;
            if(piles[i]%k!=0){
                hrs++;
            }
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1,res=-1;
        int high=Arrays.stream(piles).max().getAsInt();
        while(high>=low){
            int guess=(high+low)/2;
            if(findHrs(piles,guess)<=h){
                res=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
    }
}
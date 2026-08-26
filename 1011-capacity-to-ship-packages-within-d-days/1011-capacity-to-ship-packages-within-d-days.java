class Solution {
    public boolean shipCapacity(int weights[],int days,int guess){
        int c=1,sum=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>guess){
                return false;
            }
            sum+=weights[i];
            if(sum<=guess){
                continue;
            }
            c++;
            sum=weights[i];
        }
        if(c<=days){
            return true;
        }
        else{
            return false;
        }
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,res=0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        int low=1;
        int high=sum;
        while(high>=low){
            int guess=(high+low)/2;
            if(shipCapacity(weights,days,guess)){//first occurance
                res=guess;
                high=guess-1;
            }else{
                low=guess+1;
            }
        }
        return res;
    }
}
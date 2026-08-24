class Solution {
    public boolean citationCheck(int arr[],int guess){
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=guess){
                c++;
            }
        }
        if(c>=guess){
            return true;
        }
        return false;
    }
    public int hIndex(int[] citations) {
        int n=citations.length;
       int low=0;
       int high=n;
       int res=-1;
       while(high>=low){
        int guess=(high+low)/2;
        if(citationCheck(citations,guess)){
            res=guess;
            low=guess+1;
        }else{
            high=guess-1;
        }
       }
       return res;
    }
}
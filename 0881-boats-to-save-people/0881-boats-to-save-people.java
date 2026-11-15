class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        int boat=0,low=0,high=n-1;
        Arrays.sort(people);
        while(low<=high){
            if(people[low]+people[high]<=limit){
                low++;
                high--;
            }else{
                high--;
            }
            boat++;
        }
        return boat;
    }
}
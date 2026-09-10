class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxWater=Integer.MIN_VALUE;
        while(left<right){
            int hb=Math.min(height[left],height[right]);
            int w=right-left;
            int water=hb*w;
            maxWater=Math.max(maxWater,water);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}
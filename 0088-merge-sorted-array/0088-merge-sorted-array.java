class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int p1=0,p2=0,p3=m;
        // int count=0;
        // while(p1<p3 && p2<n){
        //     if(nums1[p1]<=nums2[p2]){
        //         p1++;
        //     }
        //     else{
        //         for(int i=p3;i>p1;i--){
        //             nums1[i]=nums1[i-1];
        //         }
        //         nums1[p1]=nums2[p2];
        //         p2++;
        //         p3++;
        //         p1++;
        //     }
        //      count++;   
        // }
        // while(p2<n){
        //         nums1[p3]=nums2[p2];
        //         p2++;
        //         p3++;

        //     }
        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;
        while(p1>=0 && p2>=0){
            if(nums1[p1]>nums2[p2]){
                nums1[p]=nums1[p1];
                p1--;
            }else{
                nums1[p]=nums2[p2];
                p2--;
            }
            p--;
        }
        while(p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}

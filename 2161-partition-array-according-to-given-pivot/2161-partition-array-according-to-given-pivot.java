
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int low = 0, mid = 0;

        // First pass: elements smaller than pivot
        while (mid < n) {
            if (nums[mid] < pivot) {
                int temp = nums[mid];

                for (int i = mid; i > low; i--) {
                    nums[i] = nums[i - 1];
                }

                nums[low] = temp;
                low++;
            }
            mid++;
        }

        // Second pass: elements equal to pivot
        mid = low;

        while (mid < n) {
            if (nums[mid] == pivot) {
                int temp = nums[mid];

                for (int i = mid; i > low; i--) {
                    nums[i] = nums[i - 1];
                }

                nums[low] = temp;
                low++;
            }
            mid++;
        }

        return nums;
    }
}

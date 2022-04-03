class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        if (nums.length == 1) {
            return 1; 
        }
        for (int i = 0; i < nums.length; i++) {
            int curProduct = nums[i];
            int j = i + 1;
            if (nums[i] < k) count++;
            while (j < nums.length && curProduct < k) {
                curProduct = curProduct * nums[j];
                if (curProduct < k) {
                    count++;
                }
                j++;
                
            }
        }
        
        return count;
    }
}

class SolutionOptimal {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}

/**
 * Optimal Solution: The window solution I was trying to go for
 * keep increasing the size of hte window until your current product is too big. If it is, keep decrementing the window from the left until it satisfies curProd < k.
 * On each iteration, the size of the window == the amount of subarrays that can be made. if the product of that window is < k, then each subarray of that window also will have a product less than k.
 * + 1 for including the value at nums[right]
 */

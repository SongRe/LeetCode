class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int k = i + 1, j = nums.length - 1;
            while(k < j) {
                int curSum = nums[i] + nums[k] + nums[j];
                if(curSum >= target) {
                    j--;
                } else {
                    // curSum < target
                    count += j - k; // all elements from here to k, will count
                    k++;
                }
            }
        }
        return count;
    }
}

// same as 3Sum and 3Sum closest, we do the three pointer strategy by fixing one at a point, then using the other two pointers to shorten our window

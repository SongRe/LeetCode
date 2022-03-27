class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 1;
        if(nums.length == 1) {
            if(nums[0] >= target) return 1;
            return 0;
        }
        if(nums[0] >= target) return 1;
        int curSum = nums[0];
        int count = 1;
        int minCount = Integer.MAX_VALUE;
        while(i < j && j < nums.length) {
            curSum += nums[j];
            count++;
            if(curSum >= target) {
                while(curSum - nums[i] >= target) {
                    curSum -= nums[i];
                    count--;
                    i++;
                }
                if(count < minCount) {
                    minCount = count;
                }
            } 
            j++; //add the next element
        }
        if(minCount == Integer.MAX_VALUE) return 0;
        return minCount;
    }
}

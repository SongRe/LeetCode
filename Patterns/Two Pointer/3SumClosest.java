public class 3SumClosest {
    
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        int closestDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int k = i + 1;
            int j = nums.length - 1;
            while(k < j) {
                int curSum = nums[i] + nums[j] + nums[k];
                int difference = Math.abs(curSum - target);
                if(difference < closestDiff) {
                    closest = curSum;
                    closestDiff = difference;
                }
                if(curSum > target) {
                    // curSum is too big
                    j--;
                } else if (curSum < target) {
                    k++;
                } else {
                    // difference == 0 so curSum == target
                    return curSum;
                }
            }
        }
        return closest;
    }
}

// similar to solution for 3 sum, we check whether or not the sum is close to the target and move our pointers accordingly
// only difference being that we need to check 

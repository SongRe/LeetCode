public class MaxConsecutiveOnesWithKFlips {
    
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int max = 0;
        
        while(right < nums.length) {
            if(nums[right] == 0) {
                if(k <= 0) {
                    max = Math.max(max, right - left);
                    while(left < right && nums[left] != 0) {
                        left++;
                    }
                    left++;
                } else {
                    k--; // we flip this, then reduce the amount of flips we can make
                }
                
            }
            right++;
        }
        max = Math.max(max, right - left);
        
        
        return max;
    }
}

/** Sliding Window Approach
 *  We have two pointers. We decrement k when we see a 0, and if we see a 0 when k is 0, then:
 *  Increment left pointer until left sees a 0, then increment left one more time to place it after that 0. This way, we -1 flip then +1 flip, resulting in net change of 0 for how many 0's flipped.
 *  Everytime we see a 0 when k <= 0, then we update the maximum.
 *  Finally, after right reaches the end of nums, we update max. 
 */

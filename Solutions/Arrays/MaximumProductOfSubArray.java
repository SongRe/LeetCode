class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int maxPro = nums[0];
        int minPro = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < 0){
                int temp = maxPro;        // swapping maxPro and minPro for negative value so that in maxPro there is always maximum value. for eg. maxPro = 10, minPro = -10 and nums[i] = -3, then if we don't swap then maxPro = 10*(-3) => -30 which should not be and in minPro there will be 30 so before calculation we have to swap their values.
                maxPro = minPro;
                minPro = temp;
            }
            maxPro = Math.max(nums[i], nums[i]*maxPro);
            minPro = Math.min(nums[i], nums[i]*minPro);
            
            if(ans < maxPro){
                ans = maxPro;
            } 
        }
        return ans;
    }
}

/**
 * basically we keep track of a maximum and minimum product (to account for negatives in the array)
 * If we encounter a negative value, we swap maximum and minimums to ensure that the maximum product variable is always the maximum product.  
 * If ans < maxProduct, make the answer the maxProduct. 
 * Start at nums[1] to save a little time.
 * 
 **/

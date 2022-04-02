public class 3Sum {
    
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) break;
            if(i != 0 && nums[i] == nums[i - 1]) continue; //skip this iteration
            int j = nums.length - 1;
            int k = i + 1;
            while(k < j) {
                int curSum = nums[i] + nums[k] + nums[j];
                if (curSum == 0) {
                    List<Integer> val = new ArrayList<Integer>(Arrays.asList(nums[i], nums[k], nums[j]));
                    result.add(val);
                    k++;
                    j--;
                    while(k + 1 < nums.length && nums[k] == nums[k - 1]) k++; // avoid duplicates 
                } else if (curSum > 0) {
                    j--;
                } else if (curSum < 0) {
                    k++;
                } 
            }            
        }
        return result;
    }
}

// idea is to fix a pointer at i, iterate through the sorted array
/** If nums[i] > 0 , break since u can't get anything below 0
 * also, if nums[i] is repeated, you just skip
 * in i, two pointers, k and j (left and right)
 * while (k < j) 
 *      take the sum of nums[i], k, j, respectively
 *      If curSum == 0, add it to the list of results and increase k and decrement j (shorten the window)
 *          while k is the same though, we still wanna increment k to avoid duplicates (this is the part i missed)
 *      then if curSum > 0, decrement j and if curSum < 0, increment k
 */

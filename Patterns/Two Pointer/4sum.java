public class 4sum {
    
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //if (nums[i] > target) break;
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                // if (nums[i] + nums[j] > target) break;
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        left++;
                        right--;
                        while (left + 1 < nums.length && nums[left] == nums[left -1]) {
                            left++; // avoid duplicates
                        }
                    } else if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;

                    }
                }
            }
        }
        return ans;
    }
}

// Similar to 3sum, pivot in 2 for loops. The for loops are two pointers, then on each iteration we decrease the sliding window..etc

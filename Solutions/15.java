import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            
            while(k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    k--;
                    while(nums[k] == nums[k + 1] && k > j) {
                        k--;
                    }
                } else if(sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j++;
                }
            }
        }
        return result;
    }
}

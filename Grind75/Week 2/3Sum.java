class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = i + 1;
            int j = nums.length - 1;
            while (k < j) {
                int sum = nums[i] + nums[k] + nums[j];
                if (sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i],nums[k],nums[j])));
                    k++;
                    j--;
                    while (k < nums.length && nums[k] == nums[k - 1]) {
                        k++; //skip dupe
                    }
                }
                if (sum > 0) {
                    j--;
                } else if (sum < 0) {
                    k++;
                }
            }

        }
        
        return result;
      
    }
}
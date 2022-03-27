/*
Initial Solution
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
            return nums.length;
        }
        int count = nums.length;
        int max = Integer.MAX_VALUE;
        int currentNumber = 0;
        boolean flag = false;
        
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                currentNumber = nums[i];
                nums[i] = '_';
                count--;
                flag = true;
            } else if(flag && nums[i] == currentNumber) {
                nums[i] = '_';
                count--;
            } else {
                flag = false;
            }
        }
        Arrays.sort(nums);
        return count;
        
        
    }
}

*/


class Solution {
    public int removeDuplicates(int[] nums) {
        
        if(nums.length < 3)
        {
            return nums.length; // why because here the values atmost will be 2
        }
        
        int index=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[index-2])// compare the values with previous indeces
            {
                nums[index++]=nums[i];
                
            }
        }
        
        return index;
    }
}

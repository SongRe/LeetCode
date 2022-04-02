public class RemoveDuplicatesFromSorteedArr {
    
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int nextNonDuplicate = 1; // keep track of the spot for the next unique number
        int i = 1;
        while(i < nums.length) {
            if(nums[nextNonDuplicate - 1] != nums[i]) {
                nums[nextNonDuplicate] = nums[i];
                nextNonDuplicate++;
            }
            i++;
        }
        return nextNonDuplicate;
    }
}

// we keep a pointer that points to the next available spot for a non duplicate (so nums[pointer - 1] is the latest element added to the resulting array )

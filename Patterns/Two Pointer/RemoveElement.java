public class RemoveElement {
    
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int nextElement = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[nextElement] = nums[i];
                nextElement++;
            }
        }
        return nextElement;
    }
}

// similar to remove duplicates from sorted array, we use a pointer to point to the next spot that we want our next element to go into. 

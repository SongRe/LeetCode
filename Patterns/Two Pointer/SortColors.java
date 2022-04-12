public class SortColors {
    
}
class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        // 
        while (low < nums.length && nums[low] == 0) {
            low++;
        }        
        while (high > 0 && nums[high] == 2) {
            high--;
        }
        
        for (int i = low; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                low++;
            } else if (nums[i] == 2) {
                if(i < high) {
                    swap(nums, i, high);
                    if(nums[high] != 1) { // nums[high] == 0, so we need to move the 0 again
                        i--; // redo this specific iteration
                    }
                }
                high--;
            }
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

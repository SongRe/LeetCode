class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        return findPeak(nums, l, r);
    }
    
    public boolean isPeakElement(int[] nums, int i) {
        if(nums.length == 1) {
            return true;
        }
        if(i == 0) {
            return nums[i] > nums[i + 1];
        }
        if(i == nums.length - 1) {
            return nums[i] > nums[i - 1];
        }
        return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
    }
    
    public int findPeak(int[] nums, int l, int r) {
        int mid = (l + r) / 2;
        //check if middle is peak element
        if(isPeakElement(nums, mid)) {
            return mid;
        } else {
            //search the half of the array that most likely has the peak. if mid + 1 is greater, then we start the next search at mid + 1.
            if(nums[mid + 1] > nums[mid]) {
                return findPeak(nums, mid + 1, r);
            }
            
            if(nums[mid - 1] > nums[mid]) {
                return findPeak(nums, l, mid - 1);
            }
        }
        return findPeak(nums, l + 1, r - 1);
    }

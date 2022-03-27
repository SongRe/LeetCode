class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return minSearch(nums, left, right);
    }
    
    public int minSearch(int[] nums, int l, int r) {
        int mid = (l + r) / 2;
        if(l == r) {
            return nums[l]; 
        }
        if(l >= mid) { 
            if(nums[mid + 1] > nums[mid]) {
                return nums[mid];
            }
            return nums[mid + 1];
        }
        
        if(nums[mid] > nums[r]) {
            return minSearch(nums, mid + 1, r);
        }
        if(nums[mid] < nums[l]) {
            return minSearch(nums, l, mid);
        }
        if(nums[l] > nums[r]) {
            return minSearch(nums, mid, r);
        }
        if(nums[l] < nums[r]) { 
            return minSearch(nums, l, mid);
        }
        
        
        return nums[mid];
    }
}

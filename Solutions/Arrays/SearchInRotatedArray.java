public class SearchInRotatedArray {
    
}

class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        
        while(i<=j){
            int mid=i+(j-i)/2; ///to prevent operator overloading
            
            if(nums[mid]==target) return mid; // return if we get the target value.
            
            if(nums[i]<=nums[mid]){ //if 1st part is sorted
                if(target>=nums[i] && target<=nums[mid])j=mid-1; //target is here, so we will look in this part
                else i=mid+1; //target is not here so we go to another part
            }else{ // if 2nd part is sorted
                if(target>=nums[mid] && target<=nums[j]) i=mid+1;//target is here, so we will look in this part
                else j=mid-1;//target is not here so we go to another part
            }
        }
        return -1;
    }
    
    public int binSearch(int[] nums, int l, int r, int target) {
        int mid = (l + r) / 2;
        if(nums[mid] == target) {
            return mid;
        }
        
        if(r == l) {
            if(nums[r] == target) return r;
            return - 1;
        }
        if(target > nums[mid]) {
            if(target <= nums[r]) {
                return binSearch(nums, mid + 1, r, target);
            } 
            return binSearch(nums, l, mid - 1, target);
           
        }
        
        if(target < nums[mid]) {
            if(target >= nums[l]) {
                return binSearch(nums, l, mid - 1, target);
            }
            return binSearch(nums, mid + 1, r, target);
        }
        return - 1;
        
        // // 2 cases: nums[mid] is the end of the original array, since it has been rotated sufficiently 
        // // or nums[mid] is not in the second half of the original array
        // if(nums[l] > nums[r] && nums[mid] > nums[l]) {
        //     if(target > nums[mid]) {
        //         return binSearch(nums, mid - 1, r, target);
        //     } 
        //     // target <= nums[mid] 
        //     if(target <= nums[r]) {
        //         return binSearch(nums, mid + 1, r, target);
        //     } 
        //     // target <= nums[mid] && target > nums[r]
        //     return binSearch(nums, l, mid - 1, target);
        // }
        // // nums[mid] is not in second half of the array [6,0,1,2,3,4,5]
        // if(target > nums[mid]) {
        //     if(target <= nums[r]) {
        //         return binSearch(nums, mid + 1, r, target);
        //     } 
        //     return binSearch(nums, l, mid - 1, target);
        // } 
        // // target <= nums[mid]
        // return binSearch(nums, l, mid, target);
    }
}

//Find first and last position of element in sorted array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = binarySearch(nums, 0, nums.length -1, target);
        int[] sol = {-1,-1};
        
        //Count left side
        //[0,0,0,1,1,2]
        int l,r = 0;
        l = firstOccurence;
        r = firstOccurence;
        if(firstOccurence == - 1) {
            return sol;
        }
        
        if(l == 0) {
            sol[0] = 0;    
        } else if(nums[l - 1] != target) {
            sol[0] = l;
        } else {
            while(nums[l - 1] == target) {
                l--;
                if (l == 0) {
                    break;
                }
            }
            sol[0] = l;
        }
        
        if(r == nums.length - 1) {
            sol[1] = r;
        } else if(nums[r + 1] != target) {
            sol[1] = r;
        } else {
            while(nums[r + 1] == target) {
                r++;
                if(r == nums.length - 1) {
                    break;
                }
            }
            sol[1] = r;
        }
        return sol;
    }
    
    public int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
 
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
 
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }
 
        // We reach here when element is not present
        // in array
        return -1;
    }
}

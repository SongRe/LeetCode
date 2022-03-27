import java.util.Arrays;

//Search in rotated array:


/**
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * If not found, return -1;
 */


//My initial solution

class Solution {
    public int search(int[] nums, int target) {
        int rot = indexOfMinVal(nums);
        System.out.println(rot);
        Arrays.sort(nums);
        int result = binarySearch(nums, 0, nums.length -1, target);
        if(result == - 1) return result;
        return (result + rot) % nums.length;
    }
    
    public int indexOfMinVal(int arr[]) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
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

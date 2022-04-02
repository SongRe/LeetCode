public class SortSquaresOfArray {
    
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int maxPointer = nums.length - 1;
        while(i <= j) {
            int lowSq = nums[i] * nums[i];
            int hiSq = nums[j] * nums[j];
            if(hiSq < lowSq) {
                arr[maxPointer] = lowSq;
                i++;
            } else {
                arr[maxPointer] = hiSq;
                j--;
            }
            maxPointer--;
        }
        return arr;
    }
}

// we fill and return a new array. We use maxPointer to point to the next spot for the highest square value. 
// Since the array nums is given in ascending order, we know that either end of the array will have the next highest value (when squared)\
// pointers i and j point to each end of the array 

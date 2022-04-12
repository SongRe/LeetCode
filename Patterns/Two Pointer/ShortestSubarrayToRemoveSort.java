public class ShortestSubarrayToRemoveSort {
    
}

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n-1;

        // move i and j to the rightmost sorted and leftmost sorted indexes 
        while (i+1 < n && arr[i] <= arr[i+1])
            i++;
        while (j-1 >= i && arr[j] >= arr[j-1])
            j--;
        
        // if they end at the same spot then it is sorted, so return 0
        if (i == j)
            return 0;
        
        // by default, the minimum is given by removing 0 -> i or i -> j
        int min = Math.min(n-i-1, j);
    
        int left = 0;
        
        while (left <= i && j < n){
            // for every value arr[j] up to arr[n - 1], we move left to the rightmost possible index while 0 -> left + j -> n is sorted
            while (left <= i && arr[left] <= arr[j]) {
                left++;
            }
            
            // if this result is shorter than min, replace it
            min = Math.min(min, j-left);
            
            
            j++;
        }
        return min;
    }
}

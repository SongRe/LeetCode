
public class Solution {
    public static void main(String args[]) {
        int[] test = new int[6];
        test[0] = 2;
        test[1] = 0;
        test[2] = 2;
        test[3] = 1;
        test[4] = 0;
        test[5] = 1;
        sortColors(test);
    }   
    
    public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        
        for(int i = 0; i < nums.length; i ++) {
            if(low < high) {
                if(nums[i] == 2) {
                    while(nums[high] == 2 && high != i) {
                        high--;
                    }
                    swap(nums, i, high);
                    high--;
                }
            
                if(nums[i] == 0) {
                    while(nums[low] == 0 && low != i) {
                        low++;
                    }
                    swap(nums, i, low);
                    low++;
                }
            }
    
        }
        
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}



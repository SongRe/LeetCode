//Binary search in 2d matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;
        int row = top + (bottom - top) / 2; 

        //first, we figure out the row our target must be in
        
        
        for(int i = bottom; i >= 0; i--) {
            if(matrix[i][right] >= target) {
                if(matrix[i][right] == target) return true;
                row = i;
 
            }
        }
//         while(top < bottom) {

//             if(matrix[top][right] >= target) {
//                 if(matrix[top][right] == target) {
//                     return true;
//                 }
//                 row = top; 
//                 bottom = -1; //exit the loop, then the target must exist in this row
//             } else if(matrix[row][right] >= target ) {  
//                 bottom = row;
//             } else {
//                 top = row + 1;
//             }
//             row = top + (bottom - top) / 2;
            
//         }
        System.out.println(row);
        //now that the row of our target is found, 
        int mid = (left + right) / 2;
        while(left < right) {
            if(matrix[row][mid] == target) {
                return true;
            }
            if(matrix[row][left] == target) {
                return true;
            }
            if(matrix[row][right] == target) {
                return true;
            }
            if(matrix[row][mid] < target) {
                left = mid + 1;
            } else if(matrix[row][mid] > target) {
                right = mid - 1;
            }
            mid = left + (right - left) /2;
        }
        return matrix[row][mid] == target;
    }
}

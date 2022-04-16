public class KClosestPointsToOrigin {
    
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // int[k - 1][] will always point to the point the furthest away from the origin 
        int [] sums = new int[k];
        sums[0] = Integer.MAX_VALUE;
        int[][] closest = new int[k][2];
        int index = 0;
        int maxIndex = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int sum = point[0] * point[0] + point[1] * point[1];
            // first populate the sums and closest arrays with the first k points
            if (index < k) {
                sums[index] = sum;
                if (sum > sums[maxIndex]) {
                    maxIndex = i; // 
                }
                closest[index++] = point;
            } else {
                if (sum < sums[maxIndex]) {
                    sums[maxIndex] = sum;
                    closest[maxIndex] = point;
                    maxIndex = findMaxIndex(sums);
                }
            }
            
            
        return closest;
        
    }
    
    int findMaxIndex(int[] sums) {
        int index = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[index]) {
                index = i;
            }
        }
        return index;
    }
}

public class 01Matrix {
    
}

/**
* To be honest I'm not too sure how this works
* With the queue 
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat.length == 0) {
            return mat;
        }
        int[][] distribution = new int[mat.length][mat[0].length];
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer,Integer>>(mat.length * mat[0].length, Comparator.comparing(Pair::getKey));
            for (int i = 0; i < distribution.length; i++) {
                for (int j = 0; j < distribution[0].length; j++) {
                    if (mat[i][j] == 0) {
                        distribution[i][j] = 0;
                        queue.add(new Pair <> (i, j)); // put the 0 in the queue
                    } else {
                        distribution[i][j] = Integer.MAX_VALUE;
                    }
                }
                
            }
        
        
        int[][] dir = { { - 1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        while (!queue.isEmpty()){
            Pair<Integer, Integer> curr = queue.peek();
            queue.remove();
            for (int i = 0; i < 4; i++) {
                int new_r = curr.getKey() + dir[i][0], new_c = curr.getValue() + dir[i][1];
                if (new_r >= 0 && new_c >= 0 && new_r < mat.length && new_c < mat[0].length) {
                    if (distribution[new_r][new_c] > distribution[curr.getKey()][curr.getValue()] + 1) {
                        distribution[new_r][new_c] = distribution[curr.getKey()][curr.getValue()] + 1;
                        queue.add(new Pair <> ( new_r, new_c ));
                    }
                }
            }
        }
        return distribution;
    }
    
}

/**
 * This approach makes a bit more sense to me
 * Basically we realize that the distribution we need to return depends on values we calculate previously. So we do two iterations:
 * 1st iteration: top down, left to right. We use the values of the previous upper and left square to calculate our current square's value
 * 2nd interation: bottom up, right to left. We use the values of down and right squares to calcualte our current square's value
 * This way, the edges that aren't accounted for on the 1st iteration are covered by the 2nd, and the edges that aren't covered by the 2nd are covered by the first.  
 * Star
 * Starred
 */
class DPSolution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0) {
            return mat;
        }
        int[][] dist = new int[mat.length][mat[0].length]; 
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE - 1000000; // initialize all of them to max value first
            }
        }
        
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) { //we aren't at the first row, so get it with the values from the prev row
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);  // so first iteration, top down left to right, 
                        // so we look at the upper box, and set it to the minimum between the two.
                        // if the one upper is 1, (meaning its 1 away from a zero, then our box must be 2 away from a zero going upwards)
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1); 
                        // we look at the box to the left (that we have just calculated)
                    }
                }
            }
        }
        
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    // if this isn't the bottom row
                    if (i < mat.length - 1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    
                    if (j < mat[0].length - 1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }
                }
            }
        }
        
        return dist;
    }
    
}



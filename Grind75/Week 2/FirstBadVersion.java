public class FirstBadVersion {
    

}

/**
 * Star : binary search bug, mid must be calculated this way
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1; 
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2; // avoid overflow bug in Binary search
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

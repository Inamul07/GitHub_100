// url: https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n, bad = 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(isBadVersion(mid)) {
                end = mid-1;
                bad = mid;
            } else start = mid+1;
        }
        return bad;
    }
}

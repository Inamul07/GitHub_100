// url: https://leetcode.com/problems/find-in-mountain-array/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    private int findPeakInMountain(MountainArray mArr) {
        int start = 0, end = mArr.length()-1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(mArr.get(mid) > mArr.get(mid+1)) end= mid;
            else start = mid+1;
        }
        return start;
    }

    public int findInMountainArray(int target, MountainArray mArr) {
        int peakIdx = findPeakInMountain(mArr);
        if(mArr.get(peakIdx) == target) return peakIdx;
        int start = 0, end = peakIdx-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mArr.get(mid) == target) return mid;
            if(mArr.get(mid) < target) start = mid+1;
            else end = mid-1;
        }
        start = peakIdx+1;
        end = mArr.length()-1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mArr.get(mid) == target) return mid;
            if(mArr.get(mid) > target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}

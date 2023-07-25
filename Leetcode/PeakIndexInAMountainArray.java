// url: https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length-1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if((mid > 0 && arr[mid-1] < arr[mid]) && (mid < arr.length-1 && arr[mid+1] < arr[mid])) return mid;
            if(arr[mid] > arr[mid-1]) start = mid+1;
            else end = mid;
        }
        return -1;
    }
}

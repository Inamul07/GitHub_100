// url: https://leetcode.com/problems/spiral-matrix-iv/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int[] row: res) Arrays.fill(row, -1);
        boolean cis = true, cds = false, ris = false, rds = false;
        int t = -1, r = n, b = m, l = -1, i = 0, j = 0;
        while(l < r && t < b) {
            res[i][j] = head.val;
            head = head.next;
            if(head == null) break;
            if(cis) j++;
            else if(cds) j--;
            else if(ris) i++;
            else i--;
            if(cis && j == r) {
                cis = false;
                ris = true;
                j--; i++;
                t++;
            } else if(ris && i == b) {
                ris = false;
                cds = true;
                i--; j--;
                r--;
            } else if(cds && j == l) {
                cds = false;
                rds = true;
                j++; i--;
                b--;
            } else if(rds && i == t) {
                rds = false;
                cis = true;
                i++; j++;
                l++;
            }
        }
        return res;
    }
}

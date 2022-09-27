// url: https://leetcode.com/problems/push-dominoes/


// Brute Force
class Solution {
    public String pushDominoes(String dominoes) {
        Queue<List<Object>> q = new LinkedList<>();
        char[] arr = dominoes.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'L' || arr[i] == 'R') {
                List<Object> l = new ArrayList<>();
                l.add(i);
                l.add(arr[i]);
                q.add(l);
            }
        }
        while(!q.isEmpty()) {
            List<Object> l = q.remove();
            int i = (int) l.get(0);
            char ch = (char) l.get(1);
            if(ch == 'L' && i-1 >= 0 && arr[i-1] == '.') {
                arr[i-1] = 'L';
                List<Object> list = new ArrayList<>();
                list.add(i-1);
                list.add(arr[i-1]);
                q.add(list);
            }
            else if(ch == 'R' && i+1 < arr.length && arr[i+1] == '.') {
                if(i+2 < arr.length && arr[i+2] == 'L') q.remove();
                else {
                    arr[i+1] = 'R';
                    List<Object> list = new ArrayList<>();
                    list.add(i+1);
                    list.add(arr[i+1]);
                    q.add(list);
                }
            }
        }
        String res = new String(arr);
        return res;
    }
}

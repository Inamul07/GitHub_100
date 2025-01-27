// url: https://leetcode.com/problems/course-schedule-iv/

class Solution {

    Map<Integer, List<Integer>> map;
    Map<Integer, Set<Integer>> reqMap;

    private Set<Integer> dfs(int node, int parent) {
        if(reqMap.containsKey(node)) return reqMap.get(node);
        Set<Integer> set = new HashSet<>();
        for(int child: map.get(node)) {
            if(parent == child) continue;
            set.addAll(dfs(child, node));
        }
        set.add(node);
        reqMap.put(node, set);
        return reqMap.get(node);
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        map = new HashMap<>();
        reqMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++) map.put(i, new ArrayList<>());
        for(int[] prerequisite: prerequisites) map.get(prerequisite[1]).add(prerequisite[0]);
        for(int i = 0; i < numCourses; i++) reqMap.put(i, dfs(i, -1));
        System.out.println(reqMap);
        for(int[] query: queries) {
            if(reqMap.get(query[1]).contains(query[0])) res.add(true);
            else res.add(false);
        }
        return res;
    }
}

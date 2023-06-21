// url: https://leetcode.com/problems/course-schedule/

class Solution {

    Map<Integer, List<Integer>> adjList;
    Set<Integer> completed;

    private boolean dfs(int node, Set<Integer> visited) {
        if(visited.contains(node)) return false;
        visited.add(node);
        for(int child: adjList.get(node)) {
            if(!completed.contains(child) && !dfs(child, visited)) return false;
        }
        completed.add(node);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        adjList = new HashMap<>();
        completed = new HashSet<>();
        for(int i = 0; i < numCourses; i++) adjList.put(i, new ArrayList<>());
        for(int[] prereq: prerequisites) adjList.get(prereq[0]).add(prereq[1]);
        for(int i = 0; i < numCourses; i++) 
            if(!completed.contains(i) && !dfs(i, new HashSet<>())) return false;
        return true;
    }
}

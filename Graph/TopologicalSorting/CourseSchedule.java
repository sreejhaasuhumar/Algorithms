package Graph.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*  There are a total of n courses you have to take, labeled from 0 to n-1.
    * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
    * which is expressed as a pair: [1,0]
    * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
    * You can assume that there are no cycles in the prerequisites.
    * Example:
    * Input:
    * numCourses = 2, prerequisites = [[1,0]]
    * Output: true
    * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0.
    * So it is possible.
 */

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return true;

        List<List<Integer>> adj = new ArrayList<>(numCourses);
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int visited = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            visited++;
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) q.add(nei);
            }
        }

        return visited == numCourses;
    }
}

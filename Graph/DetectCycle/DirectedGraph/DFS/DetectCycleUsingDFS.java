package Graph.DetectCycle.DirectedGraph.DFS;

import java.util.ArrayList;
import java.util.List;

/* Detect Cycle in Directed Graph using DFS 
 * Given a directed graph, check if it contains a cycle.
 * Note: Use the adjacency list representation of the graph.
 * Example:
 * Input: adj[][] = [[], [2], [3], [1]]
 * Output: true (The graph contains a cycle: 1 -> 2 -> 3 -> 1)
 * Explanation: The graph can be visualized as:
 * So the graph contains a cycle.
 * Another Example:
 * Input: adj[][] = [[], [2], [3], []]
 * Output: false (The graph does not contain any cycle)
 * Explanation: The graph can be visualized as:
 * So the graph does not contain any cycle.
 * LeetCode: https://leetcode.com/problems/course-schedule/
*/
public class DetectCycleUsingDFS {

    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true; // Cycle found
                }
            }
        }
        return false; // No cycle found
    }

    private static boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        recStack[node] = false; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example with a cycle
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // Cycle here (1 -> 2 -> 3 -> 1)
        adj.get(3).add(4);

        if (isCyclic(V, adj))
            System.out.println("Graph contains a cycle");
        else
            System.out.println("Graph does not contain a cycle");
    }
}

/* Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
 * Space Complexity: O(V) for the visited and recursion stack arrays.
 */
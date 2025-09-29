package Graph.DetectCycle.UndirectedGraph.DFS;

import java.util.ArrayList;
import java.util.List;

/* Detect Cycle in an Undirected Graph using DFS
 * Given an undirected graph, check whether it contains a cycle or not using DFS.
 * Note: Use the adjacency list representation of the graph.
 * Example 1:
 * Input: adj[][] = [[1,2], [0,2], [0,1], [4], [3]]
 * Output: true
 * Explanation: The graph contains a cycle (0-1-2-0).
 * Example 2:
 * Input: adj[][] = [[1], [0,2], [1,3], [2]]
 * Output: false
 * Explanation: The graph does not contain any cycle.
 * Note: A self-loop (an edge that connects a vertex to itself) is considered a cycle.
 * LeetCode: https://leetcode.com/problems/graph-valid-tree/
 */

public class DetectCycleUsingDFS {
    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, int parent) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(adj, neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // A cycle is detected
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph with a cycle
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(1);
    
}
}

/* Time Complexity:
 * - The time complexity of the DFS traversal is O(V + E), where V is the number of vertices and E is the number of edges.
 * Space Complexity: O(V) for the visited array and the recursion stack.
 */

package Graph.DetectCycle.UndirectedGraph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* Detect Cycle in an Undirected Graph using BFS
 * Given an undirected graph, check whether it contains a cycle or not using BFS.
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

public class DetectCycleUsingBFS {
    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(adj, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(List<List<Integer>> adj, int start, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, -1}); // {currentNode, parentNode}
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int parent = current[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // A cycle is detected
                }
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

        // Example graph without a cycle
        // Uncomment the following lines to test a graph without a cycle
        /*
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        */

        System.out.println("Graph contains cycle: " + hasCycle(V, adj));
    }
    
}

/* Time complexity: O(V + E), where V is the number of vertices and E is the number of edges.
 * Space complexity: O(V) for the visited array and O(V) for the queue in the worst case.
 */
package Graph.DetectCycle.UndirectedGraph.DisjointSet;


/* Detect Cycle in an Undirected Graph using Disjoint Set (Union-Find)
 * Given an undirected graph, check whether it contains a cycle or not using Disjoint Set.
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

import Graph.DisjointSets.UnionFindImplementation;

public class DetectCycleUsingUnionFind {

        public static boolean hasCycle(int n, int[][] edges) {
        UnionFindImplementation uf = new UnionFindImplementation(n);
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!uf.union(u, v)) {
                return true; // Cycle detected
            }
        }
        return false; // No cycles found
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes (0 to 4)
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0}, // This edge creates a cycle
            {3, 4}
        };
        
        boolean result = hasCycle(n, edges);
        System.out.println("Graph contains cycle: " + result);
    }
}


/* Time Complexity:
 * - The time complexity of the union-find operations (find and union) is nearly constant, amortized O(α(N)),
 *   where α is the inverse Ackermann function.
 * - Therefore, the overall time complexity for processing all edges is O(E * α(N)), where E is the number of edges.
 * Space Complexity: O(N) for storing parent and rank arrays in the union-find structure.
 */



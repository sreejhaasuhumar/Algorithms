package Graph.DisjointSets;

/* Find the redundant connection in a graph
 * Given a list of edges in an undirected graph, find the edge that, if removed,
 * makes the graph acyclic (i.e., removes a cycle).
 * Example:
 * Input: edges = [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The edge [2,3] is redundant because removing it makes the graph acyclic.
 * Note: Use the union-find (disjoint set) data structure to solve this problem.
 * LeetCode: https://leetcode.com/problems/redundant-connection/
 */

public class RedundantConnection {
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFindImplementation uf = new UnionFindImplementation(n + 1); // Nodes are 1-indexed

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!uf.union(u, v)) {
                return edge; // This edge creates a cycle
            }
        }
        return new int[0]; // No redundant connection found
    }

    public static void main(String[] args) {
        int[][] edges = {
            {1, 2},
            {1, 3},
            {2, 3} // This edge creates a cycle
        };

        int[] redundantEdge = findRedundantConnection(edges);
        if (redundantEdge.length > 0) {
            System.out.println("Redundant connection: [" + redundantEdge[0] + ", " + redundantEdge[1] + "]");
        } else {
            System.out.println("No redundant connection found.");
        }
    }
    
}

/* Time Complexity:
 * - The time complexity of the union-find operations (find and union) is nearly constant, amortized O(α(N)),
 *   where α is the inverse Ackermann function.
 * - Therefore, the overall time complexity for processing all edges is O(E * α(N)), where E is the number of edges.
 * Space Complexity: O(N) for storing parent and rank arrays in the union-find structure.
 */

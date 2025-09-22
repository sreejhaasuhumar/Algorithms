package Graph.DisjointSets;

public class CycleDetectionInUndirectedGraph {
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

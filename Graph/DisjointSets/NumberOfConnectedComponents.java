package Graph.DisjointSets;

/* Count the number of connected components in an undirected graph
 * Given n nodes (0 to n-1) and a list of undirected edges (each edge is a pair of nodes),
 * count the number of connected components in the graph.
 * Example:
 * Input: n = 5, edges = [[0,1], [1,2], [3,4]]
 * Output: 2
 * Explanation: The graph can be visualized as:
 * 0 -- 1 -- 2    3 -- 4
 * So there are 2 connected components: {0, 1, 2} and {3, 4}.
 * Note: Use the union-find (disjoint set) data structure to solve this problem.    
 * LeetCode: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberOfConnectedComponents {
    public static int countComponents(int n, int[][] edges) {
        UnionFindImplementation uf = new UnionFindImplementation(n);
        int count = n; // Initially, each node is its own component

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (uf.union(u, v)) {
                count--; // If union was successful, reduce component count
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5; // Number of nodes (0 to 4)
        int[][] edges = {
            {0, 1},
            {1, 2},
            {3, 4}
        };
        
        int result = countComponents(n, edges);
        System.out.println("Number of connected components: " + result); // Output: 2
    }
}

/* Time Complexity:
 * - The time complexity of the union-find operations (find and union) is nearly constant, amortized O(α(N)),
 *   where α is the inverse Ackermann function.
 * - Therefore, the overall time complexity for processing all edges is O(E * α(N)), where E is the number of edges.
 * Space Complexity: O(N) for storing parent and rank arrays in the union-find structure.
 */

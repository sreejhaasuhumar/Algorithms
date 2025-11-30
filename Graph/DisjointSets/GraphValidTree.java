package Graph.DisjointSets;

/*
 * Given a graph represented as an adjacency list, determine if it is a valid tree.
 * A valid tree must satisfy the following conditions:
 * 1. There are no cycles.
 * 2. All nodes are connected.
 * Example:
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 * Explanation: The graph can be visualized as:
 *     0
 *   / | \
 *  1  2  3
 *  |
 *  4
 * This is a valid tree since there are no cycles and all nodes are connected.
 */

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) return false;
        if (edges.length != n - 1) return false; // necessary condition for a tree

        UnionFindImplementation uf = new UnionFindImplementation(n);
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (!uf.union(u, v)) {
                // cycle detected
                return false;
            }
        }
        // edges == n-1 and no cycle => connected tree
        return true;
    }
}

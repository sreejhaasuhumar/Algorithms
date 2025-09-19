package Graph.TopologicalSorting;

import java.util.ArrayList;
import java.util.List;

/* Convert Edge List to Adjacency List Representation of a Graph
 * Given a list of directed edges and the number of nodes, convert it to an adjacency list representation.
 * Example:
 * Input: edges = [[5,2], [5,0], [4,0], [4,1], [2,3], [3,1]], n = 6
 * Output: Adjacency List:
 * 0: []
 * 1: []
 * 2: [3]           
 * 3: [1]
 * 4: [0, 1]
 * 5: [2, 0]
 * Explanation: The graph can be visualized as:
 *     5 → 2 → 3 → 1
 *     ↓         ↑
 *     0         |
 *     ↑         |
 *     4 ---------
 * So the adjacency list representation is as shown above.
 */

public class EdgeListToAdjacencyList {
    public static List<List<Integer>> convert(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] edges = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };
        int n = 6; // Number of nodes (0 to 5)
        List<List<Integer>> adj = convert(edges, n);
        
        // Print adjacency list
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

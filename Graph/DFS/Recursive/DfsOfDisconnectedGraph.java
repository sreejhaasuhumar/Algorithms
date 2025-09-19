package Graph.DFS.Recursive;

import java.util.ArrayList;
import java.util.List;

/* DFS of Disconnected Graph - Recursive
 * Given a disconnected undirected graph, perform a Depth First Traversal of the graph.
 * Note: Use the adjacency list representation of the graph.
 * Example 1:
 * Input: adj[][] = [[1,2], [0,2], [0,1], [4], [3]]
 * Output: 0 1 2 3 4
 * Explanation: The DFS traversal of the graph is as follows:
 * 0 is connected to 1 and 2.
 * 1 is connected to 0 and 2.
 * 2 is connected to 0 and 1.
 * 3 is connected to 4.
 * 4 is connected to 3.
 * So starting from 0, we have 0 1 2. Then we move to the next unvisited node which is 3 and have 3 4.
*/

public class DfsOfDisconnectedGraph {
    public class DfsOfConnectedGraph {
    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                 dfsRecursive(adj, i, dfs, visited);
            }
        }
        return dfs;
    }
    
    public static List<Integer> dfsRecursive(List<List<Integer>> adj, int s, List<Integer> dfs, boolean[] visited) {
        visited[s] = true;
        dfs.add(s);

        for(int i: adj.get(s)) {
            if(!visited[i]) {
                dfsRecursive(adj, i, dfs, visited);
            }
        }
        return dfs;
    }

}
    
}

/* Time Complexity: O(V + E)
 * Space Complexity: O(V+E)
 */

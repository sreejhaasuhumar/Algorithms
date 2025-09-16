package Graph.BFS;

 /*
     * BFS of Disconnected Graph
     * Given a disconnected undirected graph, perform a Breadth First Traversal of the graph.
     * Note: Use the adjacency list representation of the graph.
     * Example 1:
     * Input: adj[][] = [[1,2], [0,2], [0,1], [4], [3]]
     * Output: 0 1 2 3 4
     * Explanation: The BFS traversal of the graph is as follows:
     * 0 is connected to 1 and 2.
     * 1 is connected to 0 and 2.
     * 2 is connected to 0 and 1.
     * 3 is connected to 4.
     * 4 is connected to 3.
     * So starting from 0, we have 0 1 2. Then we move to the next unvisited node which is 3 and have 3 4.
     */

import java.util.*;

public class BfsOfDisconnectedGraph {

    public static List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // Start BFS from the unvisited vertex
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    bfs.add(node);

                    // Explore all the adjacent vertices
                    for (int neighbor : adj.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);
        adj.get(4).add(3);
        List<Integer> result = bfsOfGraph(V, adj);
        System.out.println("BFS Traversal of the disconnected graph: " + result);   
    }
    
}

/* TimeComplexity :O(V + E) where V is the number of vertices and E is the number of edges in the graph.
 * Space Complexity: O(V) for the visited array and the queue.
 */
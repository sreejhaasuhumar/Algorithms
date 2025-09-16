package Graph.BFS;

import java.util.*;

/*
 * BFS of Connected Graph
 * Given a connected undirected graph, perform a Breadth First Traversal of the graph.
 * Note: Use the adjacency list representation of the graph.
 * Example 1:
 * Input: adj[][] = [[1,2], [0,2,3], [0,1,4], [1,4], [2,3]]
 * Output: 0 1 2 3 4
 * Explanation: The BFS traversal of the graph is as follows:
 * 0 is connected to 1 and 2.
 * 1 is connected to 0, 2 and 3.
 * 2 is connected to 0, 1 and 4.
 * 3 is connected to 1 and 4.
 * 4 is connected to 2 and 3.
 * So starting from 0, we have 0 1 2 3 4
 */


class BfsOfConnectedGraph {
    public static List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from the first vertex (0)
        queue.add(0);
        visited[0] = true;

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
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(4).add(2);
        adj.get(4).add(3);

        List<Integer> result = bfsOfGraph(V, adj);
        System.out.println("BFS Traversal of the graph: " + result);
    }
}

 // Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
 // Space Complexity: O(V) for the queue and the visited array.

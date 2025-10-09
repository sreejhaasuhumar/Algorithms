package Graph.BellmanFordAlgorithm;

import java.util.Arrays;

/*
 * Bellman-Ford Algorithm Implementation
 * Given a graph and a source vertex in the graph, find the shortest paths from source to all vertices in the given graph.
 * The graph is represented using an edge list where each edge contains (u, v, weight).
 * Example:
 * Input: V = 5, edges = [[0,1,4], [0,2,8], [1,4,6], [2,3,2], [3,4,10]], src = 0
 * Output: Shortest distances from source 0 to all vertices:
 * Vertex 0: 0
 * Vertex 1: 4
 * Vertex 2: 8      
 * Vertex 3: 10
 * Vertex 4: 10
 * Explanation: The shortest path from vertex 0 to vertex 1 is 4 (direct
 * edge). The shortest path from vertex 0 to vertex 2 is 8 (direct edge).
 * The shortest path from vertex 0 to vertex 3 is through vertex 2 (0 -> 2 -> 3)
 * with total weight 10. The shortest path from vertex 0 to vertex 4 is through
 * vertex 1 (0 -> 1 ->  
 * 4) with total weight 10.
 * Note: The graph may contain negative weight edges, but no negative weight cycles.
 * LeetCode: https://leetcode.com/problems/cheapest-flights-within-k-st
 */
public class BellmanFordImplementation {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        
        // Initially distance from source to all other vertices 
        // is not known(Infinite).
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;

        // Relaxation of all the edges V times, not (V - 1) as we  
        // need one additional relaxation to detect negative cycle
        for (int i = 0; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    
                    // If this is the Vth relaxation, then there is
                    // a negative cycle
                    if (i == V - 1)
                        return new int[]{-1};
                    
                    // Update shortest distance to node v
                    dist[v] = dist[u] + wt;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        
    // Number of vertices in the graph
    int V = 5;

    // Edge list representation: {source, destination, weight}
    int[][] edges = new int[][] {
        {1, 3, 2},    
        {4, 3, -1},   
        {2, 4, 1},    
        {1, 2, 1},    
        {0, 1, 5}     
    };

    // Source vertex for Bellman-Ford algorithm
    int src = 0;

    // Run Bellman-Ford algorithm from the source vertex
    int[] ans = bellmanFord(V, edges, src);

    // Print shortest distances from the source to all vertices
    for (int dist : ans) 
        System.out.print(dist + " ");
}
}

/* Time Complexity: O(V * E) where V is the number of vertices and E is the number of edges.
 * Space Complexity: O(V) for storing the distance array.
 */

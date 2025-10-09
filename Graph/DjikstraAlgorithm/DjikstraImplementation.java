package Graph.DjikstraAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/* Dijkstra's Algorithm Implementation
 * Given a graph and a source vertex in the graph, find the shortest paths from source to all vertices in the given graph.
 * The graph is represented using an adjacency list where each list contains pairs of (neighbor, weight).
 * Example:
 * Input: V = 5, edges = [[0,1,4], [0,2,8], [1,4,6], [2,3,2], [3,4,10]], src = 0
 * Output: Shortest distances from source 0 to all vertices:
 * Vertex 0: 0
 * Vertex 1: 4
 * Vertex 2: 8
 * Vertex 3: 10
 * Vertex 4: 10
 * Explanation: The shortest path from vertex 0 to vertex 1 is 4 (direct edge).
 * The shortest path from vertex 0 to vertex 2 is 8 (direct edge).
 * The shortest path from vertex 0 to vertex 3 is through vertex 2 (0 -> 2 -> 3) with total weight 10.
 * The shortest path from vertex 0 to vertex 4 is through vertex 1 (0 -> 1 -> 4) with total weight 10.
 */

public class DjikstraImplementation {

    static class Node{
        int vertex;
        int weight;
        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        int V = 5;
        int src = 0;

        // Step A: Create adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Step B: Add edges (u, v, w)
        int[][] edges = {
            {0, 1, 4},
            {0, 2, 8},
            {1, 4, 6},
            {2, 3, 2},
            {3, 4, 10}
        };

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Node(v,w));
            adj.get(v).add(new Node(u,w)); // For undirected graph
        }

        int[] distances = djikstraAlgorithm(V, adj, src);
        System.err.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < distances.length; i++) {
            System.err.println("Vertex " + i + ": " + distances[i]);
        }
    }

    public static int[] djikstraAlgorithm(int V, List<List<Node>> adj, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n->n.weight));
        pq.add(new Node(src,0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for(Node neighbour: adj.get(u)){
                int v = neighbour.vertex;
                int w = neighbour.weight;
                
                if(dist[u]+w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }
}

/* Time Complexity: O((V + E) log V)
 * Space Complexity: O(V) for the distance array and priority queue.
 */

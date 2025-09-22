package Graph.DisjointSets;

/* Union-Find (Disjoint Set Union) Implementation
 * This class implements the Union-Find data structure with path compression and union by rank.
 * It supports two main operations:
 * 1. find: Determine the root of the set containing a particular element.
 * 2. union: Merge two sets containing two different elements.
 * Example:
 * UnionFind uf = new UnionFind(10); // Create a Union-Find with 10 elements (0 to 9)
 * uf.union(1, 2); // Merge sets containing 1 and 2
 * uf.union(2, 3); // Merge sets containing 2 and 3
 * int root = uf.find(1); // Find the root of the set containing 1 (should be same as root of 2 and 3)  
 * Logic:
 * 1. Each element is initially its own parent (self root) and has a rank of 0.
 * 2. The find operation uses path compression to flatten the structure, making future queries faster.
 * 3. The union operation uses union by rank to attach the smaller tree under the root of the larger tree, keeping the structure balanced.
 * Time Complexity:
 * - find: O(α(N)), where α is the inverse Ackermann function, which grows very slowly.
 * - union: O(α(N))
 * Space Complexity: O(N) for storing parent and rank arrays.
 */

public class UnionFindImplementation {
    int[] parent;
    int[] rank;
    public UnionFindImplementation(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int x) {
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }   

    public boolean union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY){
            return false;
        }

        if(rank[rootX]<rank[rootY]){
            parent[rootX] = rootY;

        } else if(rank[rootX]>rank[rootY]) {
            parent[rootY] = rootX;

        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }

    public static void main(String[] args) {
        UnionFindImplementation uf = new UnionFindImplementation(5); // elements: 0,1,2,3,4

        uf.union(0, 1); // connect 0 and 1
        uf.union(1, 2); // connect 1 and 2 (so now 0,1,2 are in one set)

        System.out.println(uf.find(0)); // prints leader of set containing 0
        System.out.println(uf.find(2)); // prints same leader as above (because 0 and 2 are connected)

        System.out.println(uf.find(3)); // prints different leader (3 is not connected)
    }
}

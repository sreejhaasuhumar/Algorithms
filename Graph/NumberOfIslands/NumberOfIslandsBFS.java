package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    * Number of Islands using DFS
    * Given a 2D grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
    * all four edges of the grid are all surrounded by water.
    * Example 1:
    * Input:
    * 11110
    * 11010
    * 11000
    * 00000
    * Output: 1
 */

public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    queue.add(new int[] { i, j });
                }

                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int x = curr[0];
                    int y = curr[1];

                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
                        continue;
                    }

                    grid[x][y] = '0'; // mark as visited

                    for (int[] dir : directions) {
                        int nx = x + dir[0];
                        int ny = y + dir[1];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                            queue.offer(new int[] { nx, ny });
                        }
                    }
                }
            }

        }
        return count;

    }
}

/* 
 * Time complexity: O(M*N) where M is the number of rows and N is the number of columns in the grid.
 * Space complexity: O(min(M,N)) for the queue in the BFS traversal.
 */
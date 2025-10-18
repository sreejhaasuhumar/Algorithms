package Graph;

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
public class NumberOfIslandsDFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++) {
                if(grid[i][j]=='1') {
                    count++;
                    dfs(i, j, grid);
                }

            }
        }

        return count;
    }

    public void dfs(int i, int j, char[][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1') {
            return;
        }
        grid[i][j]='0';
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}

/* 
 * Time complexity: O(M*N) where M is the number of rows and N is the number of columns in the grid.
 * Space complexity: O(M*N) in the worst case when the grid is filled with lands ('1's) and the DFS stack goes M*N deep.
 */

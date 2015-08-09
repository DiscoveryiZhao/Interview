package Graph.FloodFill;

/**
 * Created by yizhao on 8/9/15.
 */
public class NumberOfIslands {
    int count;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(grid, i, j, m, n)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(char[][] grid, int i, int j, int m, int n){
        if(i < 0 || i >= m || j < 0 || j >=n){
            return false;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i + 1, j, m, n);
            dfs(grid, i - 1, j, m, n);
            dfs(grid, i, j + 1, m, n);
            dfs(grid, i, j - 1, m, n);
            return true;
        }
        return false;
    }
}

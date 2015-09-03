package Recursion.DFS.Others;

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
                if(dfs(grid, i, j)){
                    count++;
                }
            }
        }
        return count;
    }

    // 这里的boolean返回值代表从grid[i][j]一直走到边界，是否是一座island
    public boolean dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >=grid[0].length){
            return false;
        }
        if(grid[i][j] == '1'){
            grid[i][j] = '0'; // 当探测出陆地的时候，将陆地变为海洋，这样下一次就不会重复经过这块陆地了。
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
            return true;
        }
        return false;
    }
}

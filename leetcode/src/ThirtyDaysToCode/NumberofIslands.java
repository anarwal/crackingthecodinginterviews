package ThirtyDaysToCode;

//Problem: https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int numIslands=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                // check only if the value is 1
                if(grid[i][j] == '1'){
                    numIslands +=dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    int dfs(char[][] array, int i, int j){
        // if above the array, passed the 2D array length, before left
        if(i<0 || i>=array.length || j<0 || j>=array[i].length || array[i][j]=='0') return 0;

        array[i][j]='0'; //after visiting set current node to 0 i.e. 'visited'

        dfs(array, i+1, j); //check the value below
        dfs(array, i-1, j); //check the value above
        dfs(array, i, j+1); //check the right value
        dfs(array, i,j-1);  //check the left value
        return 1;
    }
}

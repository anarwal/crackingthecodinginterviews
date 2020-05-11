package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangeBFS {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return -1;
        int counter =0;
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    counter++;

                } else if (grid[i][j] == 2) {
                    queue.add("" + i + j);
                }
            }
        }

        if(counter ==0) return 0;
        int minutes = -1;
        int directions[][] = {{0, 1}, {1,0}, {0, -1}, {-1, 0}};

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String s= queue.remove();
                int m = s.charAt(0)-'0';
                int n = s.charAt(1)-'0';
                for(int[] direction : directions){
                    int nextM = m+direction[0];
                    int nextN = n+direction[1];
                    if(nextM>=0 && nextM<grid.length && nextN>=0 && nextN<grid[0].length){
                        if(grid[nextM][nextN]==1){
                            grid[nextM][nextN]=2;
                            queue.add(""+nextM+nextN);
                            counter--;
                        }
                    }
                }
            }
            minutes++;
        }
        return counter == 0 ? minutes: -1;
    }
}

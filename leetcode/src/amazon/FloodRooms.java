package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class FloodRooms {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int directions[][] = {{1, 0}, {-1,0}, {0, 1}, {0, -1}};

        int m = image.length;
        int n = image[0].length;

        int color = image[sr][sc];
        image[sr][sc] = newColor;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();
                visited[curr[0]][curr[1]] = true;
                for (int[] direction : directions) {
                    int nextR = curr[0] + direction[0];
                    int nextC = curr[1] + direction[1];
                    if (nextR < 0 || nextC < 0 || nextR >= m || nextC >= n || image[nextR][nextC] != color || visited[nextR][nextC]) {
                        continue;
                    }
                    image[nextR][nextC] = newColor;
                    queue.offer(new int[]{nextR, nextC});
                }

            }

        }
        return image;
    }
}

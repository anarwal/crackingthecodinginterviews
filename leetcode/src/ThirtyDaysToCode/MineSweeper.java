package ThirtyDaysToCode;

public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {

        char c = board[click[0]][click[1]];

        int[] dirs = new int[]{1,0,-1,0,1,1,-1,-1,1};

        // check if mine then set the block to X
        if (c == 'M') {
            board[click[0]][click[1]] = 'X';
        }
        // if its E then perform DFS
        else if (c == 'E') {
            dfs(board, click[0], click[1], dirs);
        }
        return board;
    }

    public void dfs(char[][] board, int row, int col, int[] dir){
        int r = board.length;
        int c = board[0].length;

        board[row][col] = 'B';
        int mines = 0;

        //updating mine box
        for(int i=0; i<8; i++){
            int nextR = r + dir[i];
            int nextC = c + dir[i+1];
            if (isValid(nextR, nextC, r, c) && board[nextR][nextC] == 'M') {
                mines++;
            }
        }

        //updating boxes next to mine
        if(mines>0){
            board[r][c] = (char) (mines + '0');
        }
        //updating not next to mine and next E
        else{
            for(int i=0; i<8; i++){
                int nextR = r + dir[i];
                int nextC = c + dir[i+1];
                if (isValid(nextR, nextC, r, c) && board[nextR][nextC] == 'B') {
                    dfs(board, nextR, nextC, dir);
                }
            }
        }
    }

    //check if we are in valid matrix
    private boolean isValid(int row, int col, int rows, int cols) {
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }


}

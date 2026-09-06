class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int col=0;col<n;col++){
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }

            if (board[m - 1][col] == 'O') {
                dfs(board, m - 1, col);
            }
        }
         for (int row = 0; row < m; row++) {

            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }

            if (board[row][n - 1] == 'O') {
                dfs(board, row, n - 1);
            }
        }
         for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                else if (board[row][col] == 'S') {
                    board[row][col] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int row,int col){

                if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        // Not an O
        if (board[row][col] != 'O') {
            return;
        }

        // Mark this O as safe
        board[row][col] = 'S';

        // Up
        dfs(board, row - 1, col);

        // Down
        dfs(board, row + 1, col);

        // Left
        dfs(board, row, col - 1);

        // Right
        dfs(board, row, col + 1);
    }
    }

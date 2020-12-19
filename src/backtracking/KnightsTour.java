package backtracking;

public class KnightsTour {
    public static void main(String[] args) {
        solveKnightsTour();
    }

    private static void solveKnightsTour() {
        int[][] sol = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sol[i][j] = -1;
            }
        }

        int[] movesInxaxis = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] movesInyaxis = {1, 2, 2, 1, -1, -2, -2, -1};

        // initialize first box to 0, as we start from there
        sol[0][0] = 0;

        if (!solveKnightTourUtil(0, 0, 1, sol, movesInxaxis, movesInyaxis)) {
            System.out.println("solution not possible");
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(sol[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean solveKnightTourUtil(int i, int j, int idxOnBoard, int[][] board, int[] tox, int[] toy) {
        // if index on board reached 64, it means we covered all steps on board.
        if (idxOnBoard == 64) {
            return true;
        }

        // try all next moves from this position, we can move 8 ways.
        for (int k = 0; k < 8; k++) {
            // move from current position.
            int nextX = i + tox[k];
            int nextY = j + toy[k];
            // check if the next position is moving away from board or traversed.
            if (nextX >= 0 && nextY >= 0 && nextX < 8 && nextY < 8 && board[nextX][nextY] == -1) {
                // fill position with index.
                board[nextX][nextY] = idxOnBoard;
                // if next move is possible, return to the caller with true.
                if (solveKnightTourUtil(nextX, nextY, idxOnBoard + 1, board, tox, toy)) {
                    return true;
                } else {
                    // else make the index marked to -1 and return false.
                    board[nextX][nextY] = -1;
                }
            }
        }

        return false;
    }
}

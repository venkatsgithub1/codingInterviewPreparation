package backtracking;

/*
Program to print paths going from top to right to down and top to down to right
 */
public class PrintAllPossiblePaths {
    public static void main(String[] args) {
        int m = 2, n = 3;
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int matrixPathLength = m + n - 1;
        printMatrix(mat, 0, 0, m, n, new int[matrixPathLength], 0);
    }

    private static void printMatrix(int[][] mat, int i, int j, int m, int n, int[] path, int idx) {
        // populate path indices in path.
        path[idx] = mat[i][j];

        // reached bottom, move right and print path.
        if (i == m - 1) {
            for (int k = j + 1, l = idx + 1; k < n; k++, l++) {
                path[l] = mat[i][k];
            }
            for (int x = 0; x < m + n - 1; x++) {
                System.out.print(path[x] + " ");
            }
            System.out.println();
            return;
        }

        // reached right, move bottom and print path.
        if (j == n - 1) {
            for (int k = i + 1, l = idx + 1; k < m; k++, l++) {
                path[l] = mat[k][j];
            }
            for (int x = 0; x < m + n - 1; x++) {
                System.out.print(path[x] + " ");
            }
            System.out.println();
            return;
        }
        // move down
        printMatrix(mat, i + 1, j, m, n, path, idx + 1);
        // move right
        printMatrix(mat, i, j + 1, m, n, path, idx + 1);
    }
}

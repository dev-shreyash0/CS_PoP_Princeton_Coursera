/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    public static int size(int[][] a) {

        int max = 0, n = a[0].length;

        int[][] b = new int[n][n];

        for (int i = 0; i < n; i++) b[0][i] = a[0][i];
        for (int i = 0; i < n; i++) b[i][0] = a[i][0];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {

                if (a[i][j] == 1) b[i][j] = 1;

                if (a[i][j] == 1 && b[i - 1][j - 1] != 0) {

                    int m = b[i - 1][j - 1];

                    boolean c = true;

                    for (int h = 1; h <= m; h++) if (a[i][j - h] == 0) c = false;
                    for (int h = 1; h <= m; h++) if (a[i - h][j] == 0) c = false;

                    if (c) {
                        b[i][j] = m + 1;
                        if (max < m + 1) max = m + 1;
                    }

                }

            }
        }

        return max;

    }

    public static void main(String[] args) {

        int n = StdIn.readInt();

        int[][] b = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                b[i][j] = StdIn.readInt();

        System.out.print(size(b));

    }
}

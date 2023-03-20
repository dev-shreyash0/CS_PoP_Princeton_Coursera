/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TrinomialDP {

    public static long trinomial(int n, int k) {

        k = Math.abs(k);
        if (n == 0 && k == 0) return 1;
        if (n < k) return 0;

        long[][] t = new long[n + 1][(2 * n) - 1 + k];

        for (int i = 0; i <= n; i++) {
            int e;
            if (i == 0) e = 0;
            else e = i - 1;
            for (int j = e; j < (2 * n) - 1 + k - e; j++) {

                int k1 = j - n + 1;

                if (i == 0 && k1 == 0) {
                    t[i][j] = 1;
                }
                else if (k1 < -i || k1 > i) {
                    t[i][j] = 0;
                }
                else {
                    t[i][j] = t[i - 1][j - 1] + t[i - 1][j] + t[i - 1][j + 1];
                }

            }
        }

        return t[n][n - 1 + k];

    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(trinomial(n, k));

    }

}

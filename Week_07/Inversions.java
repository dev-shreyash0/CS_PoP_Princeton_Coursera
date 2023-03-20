/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Inversions {
    

    public static long count(int[] a) {

        long count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) count++;
            }
        }

        return count;

    }

    public static int[] generate(int n, long k) {

        int[] p = new int[n];

        int m = n - 1, pI = 0;

        while (m < k) {
            p[pI] = m;
            pI++;
            k -= m;
            m--;
        }

        p[(int) (n - 1 - k)] = m;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (p[i] == 0) {
                p[i] = count;
                count++;
            }
        }

        return p;

    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        int[] p = generate(n, k);

        for (int i = 0; i < n; i++) System.out.print(p[i] + " ");

    }
}

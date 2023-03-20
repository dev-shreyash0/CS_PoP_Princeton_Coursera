/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Ramanujan {

    public static boolean isRamanujan(long n) {

        long k1 = 1;
        long k2 = (int) Math.ceil(Math.pow((n * 1.0), 1.0 / 3));

        int count = 0;

        while (k1 < k2) {

            long k = (k1 * k1 * k1) + (k2 * k2 * k2);

            if (k < n) {
                k1++;
            }
            else if (k > n) {
                k2--;
            }
            else {
                k1++;
                k2--;
                count++;
            }

        }

        if (count >= 2) return true;
        return false;

    }

    public static void main(String[] args) {

        long n = Long.parseLong(args[0]);

        System.out.println(isRamanujan(n));

    }

}

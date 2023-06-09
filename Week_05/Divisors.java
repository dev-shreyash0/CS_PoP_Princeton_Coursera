/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Divisors {

    public static int gcd(int a, int b) {

        if (a == 0 && b == 0) return 0;

        int divisor = Math.abs(a);
        int dividend = Math.abs(b);

        if (divisor > dividend) {
            int temp = dividend;
            dividend = divisor;
            divisor = temp;
        }

        while (divisor != 0) {
            int rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }

        return dividend;

    }

    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }

    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a, b) == 1) return true;
        return false;
    }

    public static int totient(int a) {

        if (a <= 0) return 0;
        
        int t = 0;

        for (int i = 1; i <= Math.abs(a); i++) if (areRelativelyPrime(i, a)) t++;

        return t;

    }

    public static void main(String[] args) {

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        StdOut.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
        StdOut.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
        StdOut.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
        StdOut.println("totient(" + a + ")" + " = " + totient(a));
        StdOut.println("totient(" + b + ")" + " = " + totient(b));

    }
}

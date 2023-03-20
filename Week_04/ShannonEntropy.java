/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);

        double[] p = new double[m + 1];

        int count = 0;

        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            count++;
            p[x]++;
        }

        for (int i = 0; i < p.length; i++) p[i] = p[i] / count;

        double[] log = new double[m + 1];

        for (int i = 0; i < log.length; i++) {
            if (p[i] == 0) log[i] = 0;
            else log[i] = Math.log10(p[i]) / Math.log10(2);
        }

        double h = 0;

        for (int i = 0; i < p.length; i++) h += p[i] * log[i];

        StdOut.println(String.format("%.4f", -h));

    }
}

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Checkerboard {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);

        StdDraw.setScale(0, n);

        boolean b = true;

        for (int i = 0; i < n; i++) {
            if (n % 2 == 0 && i != 0) b = !b;
            for (int j = 0; j < n; j++) {
                if (b) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    b = false;
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    b = true;
                }
                StdDraw.filledSquare(0.5 + i, 0.5 + j, 0.5);
            }
        }

    }
}

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class RecursiveSquares {

    public static void drawSquare(double x, double y, double length) {

        double m = length / 2;
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, m);

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, m);

    }

    public static void draw(int n, double x, double y, double length) {
        if (n == 1) {
            drawSquare(x, y, length);
            return;
        }
        double m = length / 2;
        draw(n - 1, x - m, y + m, m);
        draw(n - 1, x + m, y + m, m);
        drawSquare(x, y, length);
        draw(n - 1, x - m, y - m, m);
        draw(n - 1, x + m, y - m, m);
    }

    public static void main(String[] args) {

        int order = Integer.parseInt(args[0]);

        draw(order, 0.5, 0.5, 0.5);

    }
}

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class ColorHSB {

    private int hue, sat, bri;

    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");

        hue = h;
        sat = s;
        bri = b;
    }

    public String toString() {
        return "(" + hue + ", " + sat + ", " + bri + ")";
    }

    public boolean isGrayscale() {
        if (sat == 0 || bri == 0) return true;
        return false;
    }

    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) throw new IllegalArgumentException("color should not be null");
        return (int) (
                Math.min(Math.pow((hue - that.hue), 2), Math.pow(360 - Math.abs(hue - that.hue), 2))
                        + Math.pow(sat - that.sat, 2) + Math.pow(bri - that.bri, 2));
    }


    public static void main(String[] args) {

        String col1 = "";

        int h1 = Integer.parseInt(args[0]);
        int s1 = Integer.parseInt(args[1]);
        int b1 = Integer.parseInt(args[2]);

        ColorHSB c1 = new ColorHSB(h1, s1, b1);
        ColorHSB c = new ColorHSB(h1, s1, b1);

        int d1 = Integer.MAX_VALUE;

        while (!StdIn.isEmpty()) {

            String col2 = StdIn.readString();
            int h2 = StdIn.readInt();
            int s2 = StdIn.readInt();
            int b2 = StdIn.readInt();

            ColorHSB c2 = new ColorHSB(h2, s2, b2);
            int d2 = c1.distanceSquaredTo(c2);

            if (d2 < d1) {
                d1 = d2;
                col1 = col2;
                c.hue = h2;
                c.sat = s2;
                c.bri = b2;
            }

        }

        System.out.println(col1 + " " + c);

    }
}

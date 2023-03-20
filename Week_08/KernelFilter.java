/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 ******************************************************************************/

import java.awt.Color;

public class KernelFilter {

    private static Picture kernel(Picture picture, double[][] k) {

        int w = picture.width(), h = picture.height(), order = k[0].length;

        Picture p = new Picture(w, h);

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {

                double r1 = 0, g1 = 0, b1 = 0;

                for (int i = 0; i < order; i++) {
                    for (int j = 0; j < order; j++) {

                        int iR = (r - order / 2 + j + h) % h;
                        int iC = (c - order / 2 + i + w) % w;

                        Color c1 = picture.get(iC, iR);

                        r1 += k[i][j] * c1.getRed();
                        g1 += k[i][j] * c1.getGreen();
                        b1 += k[i][j] * c1.getBlue();

                    }
                }

                int r2 = (int) Math.round(r1);
                int g2 = (int) Math.round(g1);
                int b2 = (int) Math.round(b1);

                if (r2 < 0) r2 = 0;
                if (g2 < 0) g2 = 0;
                if (b2 < 0) b2 = 0;

                if (r2 > 255) r2 = 255;
                if (g2 > 255) g2 = 255;
                if (b2 > 255) b2 = 255;

                Color c2 = new Color(r2, g2, b2);

                p.set(c, r, c2);

            }
        }

        return p;

    }

    public static Picture identity(Picture picture) {
        Picture p = new Picture(picture);
        return p;
    }

    public static Picture gaussian(Picture picture) {

        double[][] k = {
                { 1.0 / 16, 2.0 / 16, 1.0 / 16 },
                { 2.0 / 16, 4.0 / 16, 2.0 / 16 },
                { 1.0 / 16, 2.0 / 16, 1.0 / 16 }
        };

        return kernel(picture, k);

    }

    public static Picture sharpen(Picture picture) {

        double[][] k = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 }
        };

        return kernel(picture, k);

    }

    public static Picture laplacian(Picture picture) {

        double[][] k = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 }
        };

        return kernel(picture, k);

    }

    public static Picture emboss(Picture picture) {

        double[][] k = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 }
        };

        return kernel(picture, k);

    }

    public static Picture motionBlur(Picture picture) {

        double[][] k = {
                { 1.0 / 9, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1.0 / 9, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1.0 / 9, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1.0 / 9, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1.0 / 9, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1.0 / 9, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 1.0 / 9, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1.0 / 9, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1.0 / 9 }
        };

        return kernel(picture, k);
    }

    public static void main(String[] args) {

    }

}

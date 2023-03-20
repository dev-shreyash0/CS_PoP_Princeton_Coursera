/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class AudioCollage {

    public static double[] amplify(double[] a, double alpha) {

        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) b[i] = alpha * a[i];
        return b;

    }

    public static double[] reverse(double[] a) {

        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) b[i] = a[a.length - 1 - i];

        return b;

    }

    public static double[] merge(double[] a, double[] b) {

        double[] r = new double[a.length + b.length];

        int rI = 0;

        for (int i = 0; i < a.length; i++, rI++) r[rI] = a[i];

        for (int i = 0; i < b.length; i++, rI++) r[rI] = b[i];

        return r;

    }

    public static double[] mix(double[] a, double[] b) {

        int rLen = 0;

        if (a.length > b.length) rLen = a.length;
        else rLen = b.length;

        double[] r = new double[rLen];

        if (a.length > b.length) {
            int rI = 0;
            for (int i = 0; i < b.length; i++, rI++) r[rI] = a[i] + b[i];
            for (int i = rI; i < a.length; i++, rI++) r[rI] = a[i];
        }
        else {
            int rI = 0;
            for (int i = 0; i < a.length; i++, rI++) r[rI] = a[i] + b[i];
            for (int i = rI; i < b.length; i++, rI++) r[rI] = b[i];
        }

        return r;

    }

    public static double[] changeSpeed(double[] a, double alpha) {

        double[] b = new double[(int) (a.length / alpha)];

        for (int i = 0; i < b.length; i++) b[i] = a[(int) (i * alpha)];

        return b;

    }

    public static void main(String[] args) {

        double[] a1 = StdAudio.read("beatbox.wav");
        double[] a2 = StdAudio.read("buzzer.wav");
        double[] a3 = StdAudio.read("chimes.wav");
        double[] a4 = StdAudio.read("cow.wav");
        double[] a5 = StdAudio.read("dialup.wav");

        StdAudio.play(amplify(a1, 0.2));
        StdAudio.play(reverse(a2));
        StdAudio.play(merge(a2, a3));
        StdAudio.play(mix(a3, a4));
        StdAudio.play(changeSpeed(a5, 0.5));
        
    }
}

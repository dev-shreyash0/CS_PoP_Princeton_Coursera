/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Clock {

    private int hrs, min;

    public Clock(int h, int m) {

        if (h < 0 || h > 23)
            throw new IllegalArgumentException("hours should be between 00 and 23");
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("minutes should be between 00 and 59");

        hrs = h;
        min = m;

    }

    public Clock(String s) {

        String h1 = s.substring(0, 2);
        String m1 = s.substring(3, 5);

        int h = Integer.parseInt(h1);
        int m = Integer.parseInt(m1);

        if (h < 0 || h > 23)
            throw new IllegalArgumentException("hours should be between 00 and 23");
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("minutes should be between 00 and 59");
        hrs = h;
        min = m;

    }

    public String toString() {

        int h = hrs, m = min;

        String time = "";

        if (h < 10) time += "0" + h + ":";
        else time += h + ":";
        if (m < 10) time += "0" + m;
        else time += m;

        return time;

    }

    public boolean isEarlierThan(Clock that) {

        if (hrs < that.hrs) return true;
        if (hrs > that.hrs) return false;

        if (min < that.min) return true;
        if (min > that.min) return false;

        return false;

    }

    public void tic() {

        if (min < 59) {
            min++;
        }
        else {
            if (hrs < 23) {
                hrs++;
            }
            else {
                hrs = 0;
            }
            min = 0;
        }

    }

    public void toc(int delta) {
        if (delta < 0) throw new IllegalArgumentException("time cannot be negative");
        for (int i = 0; i < delta; i++) this.tic();
    }

    public static void main(String[] args) {

        Clock c1 = new Clock(3, 30);
        Clock c2 = new Clock(3, 59);

        Clock c3 = new Clock(23, 45);

        System.out.println(c1);

        c2.tic();
        System.out.println(c2);

        c3.toc(60);
        System.out.println(c3);

    }
}

/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Huntingtons {

    public static int maxRepeats(String dna) {

        int max = 0, i = 0, count = 0;

        while (i < dna.length()) {

            if (i + 3 <= dna.length() && dna.substring(i, i + 3).equals("CAG")) {
                count++;
                if (count > max) max = count;
                i += 3;
            }
            else {
                count = 0;
                i++;
            }
        }

        return max;

    }

    public static String removeWhitespace(String s) {
        s = s.replace("\n", "");
        s = s.replace("\t", "");
        s = s.replace(" ", "");
        return s;
    }

    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 10 && maxRepeats <= 35) return "normal";
        if (maxRepeats >= 36 && maxRepeats <= 39) return "high risk";
        if (maxRepeats >= 40 && maxRepeats <= 180) return "Huntington's";
        return "not human";
    }

    public static void main(String[] args) {

        In datafile = new In(args[0]);
        String s = datafile.readAll();

        s = removeWhitespace(s);

        int max = maxRepeats(s);

        System.out.println("max repeats = " + max);
        System.out.println(diagnose(max));

    }
}

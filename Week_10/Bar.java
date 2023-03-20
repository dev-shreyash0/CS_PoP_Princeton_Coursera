/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Bar implements Comparable<Bar> {

    private final String n, c;

    private final int v;

    public Bar(String name, int value, String category) {

        if (name == null || category == null)
            throw new IllegalArgumentException("name or category is null");
        if (value < 0) throw new IllegalArgumentException("value can't be negative");

        n = name;
        v = value;
        c = category;

    }

    public String getName() {
        return this.n;
    }

    public int getValue() {
        return this.v;
    }

    public String getCategory() {
        return this.c;
    }

    public int compareTo(Bar that) {

        if (that == null) throw new NullPointerException("comparison to null not possible");

        return Integer.compare(this.v, that.getValue());

    }

    public static void main(String[] args) {

    }

}

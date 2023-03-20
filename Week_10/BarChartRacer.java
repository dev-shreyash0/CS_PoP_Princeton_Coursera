/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {


    public static void main(String[] args) {

        String filename = args[0];
        int n = Integer.parseInt(args[1]);

        In file = new In(filename);

        String title = file.readLine();
        String xAxis = file.readLine();
        String source = file.readLine();
        // System.out.println(title + " " + xAxis + " " + source);
        BarChart chart = new BarChart(title, xAxis, source);
        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(1000, 700);

        while (!file.isEmpty()) {

            chart.reset();

            int m = file.readInt();
            String k = file.readLine();

            Bar[] data = new Bar[m];
            String date = "";

            for (int i = 0; i < m; i++) {
                String d = file.readLine();
                // System.out.println(d);
                String[] line = d.split(",");
                //  System.out.println(line);
                date = line[0];
                data[i] = new Bar(line[1], Integer.parseInt(line[3]), line[4]);
            }

            Arrays.sort(data, Collections.reverseOrder());

            chart.setCaption(date);

            for (int i = 0; i < n; i++) {
                chart.add(data[i].getName(), data[i].getValue(), data[i].getCategory());
            }

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);


        }

    }
}

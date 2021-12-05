import tools.ReaderString;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.regex.Pattern;

public class Day5 {

    private static final Pattern COMPILE = Pattern.compile(" -> ");

    public static int gaming1(String input, int size) {
        ArrayList<String> arr = ReaderString.read(input);
        int result = 0;
        Integer[][] vents = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                vents[i][j] = 0;
            }
        }

        for (String s : arr) {
            ArrayList<String> points = getPoints(s);
            for (String p : points) {
                String[] p1 = p.split(",");
                int x = Integer.parseInt(p1[0]), y = Integer.parseInt(p1[1]);
                vents[y][x]++;
            }
        }
        for (
                int i = 0;
                i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (vents[i][j] >= 2) {
                    result++;
                }
            }
        }
        return result;
    }

    private static int state(final int x, final int y) {

        return Integer.compare(y, x);
    }

    private static boolean isBigger(final int x, final int y) {
        return y > x;
    }

    private static ArrayList<String> getPoints(String s) {
        ArrayList<String> points = new ArrayList<>();
        final String[] s1 = COMPILE.split(s);
        final String[] split2 = s1[0].split(",");
        final String[] split = s1[1].split(",");
        int x1 = Integer.parseInt(split2[0]),
                x2 = Integer.parseInt(split[0]),
                y1 = Integer.parseInt(split2[1]),
                y2 = Integer.parseInt(split[1]);
        if (state(x1, x2) != 0) {
            for (int i = 0; isBigger(x1, x2) ? i < x2 - x1 + 1 : i < x1 - x2 + 1; i++) {
                points.add("");
            }
        } else {
            for (int i = 0; isBigger(y1, y2) ? i < y2 - y1 + 1 : i < y1 - y2 + 1; i++) {
                points.add("");
            }
        }
        valueValidation(points, x1, x2);
        valueValidation(points, y1, y2);
        return points;
    }

    private static void valueValidation(ArrayList<String> points, int x, int y) {
        final int state = state(x, y);
        final boolean bigger = isBigger(x, y);
        if (state == 0) {
            for (int i = 0; i < points.size(); i++) {
                final String temp = points.get(i);
                points.remove(i);
                if (temp.equals("")) {
                    points.add(i, temp + ((x)));
                } else {
                    points.add(i, temp + "," + ((x)));
                }
            }
        } else {
            for (int i = 0; i < points.size(); i++) {
                final String temp = points.get(i);
                points.remove(i);
                if (bigger) {
                    if (temp.equals("")) {
                        points.add(i, temp + ((x + i)));
                    } else {
                        points.add(i, temp + "," + ((x + i)));
                    }
                } else {
                    if (temp.equals("")) {
                        points.add(i, temp + ((x - i)));
                    } else {
                        points.add(i, temp + "," + ((x - i)));
                    }
                }
            }
        }
    }
}


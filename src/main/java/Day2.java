import tools.ReaderString;

import java.util.ArrayList;

public class Day2 {
    public static int gaming1(String input) {
        int hor = 0;
        int vert = 0;
        ArrayList<String> arr = ReaderString.read(input);

        for (String s : arr) {
            String[] line = s.split(" ");
            int value = Integer.parseInt(line[1]);
            switch (line[0]) {
                case "forward" -> hor += value;
                case "down" -> vert += value;
                case "up" -> vert -= value;
            }
        }
        return hor*vert;
    }
    public static int gaming2(String input) {
        int hor = 0;
        int vert = 0;
        int aim = 0;
        ArrayList<String> arr = ReaderString.read(input);

        for (String s : arr) {
            String[] line = s.split(" ");
            int value = Integer.parseInt(line[1]);
            switch (line[0]) {
                case "forward" -> {
                    hor += value;
                    vert += aim * value;
                }
                case "down" -> aim += value;
                case "up" -> aim -= value;
            }
        }
        return hor*vert;
    }
}

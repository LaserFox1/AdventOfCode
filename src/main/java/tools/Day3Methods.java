package tools;

import java.util.ArrayList;
import java.util.Arrays;

public class Day3Methods {
    public static ArrayList<String> removeItem(ArrayList<String> arr, int column, String bit) {
        arr.removeIf(item -> ((!item.split("")[column]
                .equals(bit)) && (arr.size() - 1 != 0)));
        return arr;
    }

    public static String highestBit(ArrayList<String> arr, int column) {
        int counter = arr.stream()
                .filter(s -> s.split("")[column]
                .equals("1"))
                .mapToInt(s -> Integer.parseInt(s.split("")[column]))
                .sum();

        if (counter >= (double) arr.size() / 2) {
            counter = 1;
        } else {
            counter = 0;
        }
        return String.valueOf(counter);
    }

    public static String lowestBit(ArrayList<String> arr, int column) {
        int counter = 0;
        for (String s : arr) {
            if (s.split("")[column].equals("0")) {
                counter++;
            }
        }
        if (counter <= (double) arr.size() / 2) {
            counter = 0;
        } else {
            counter = 1;
        }
        return String.valueOf(counter);
    }
}

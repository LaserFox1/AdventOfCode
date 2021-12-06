import tools.ReaderInt;
import tools.ReaderString;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Day6 {
    public static long gaming1(String input, int days) {
        String[] arr = ReaderString.read(input).get(0).split(",");
        Long[] arrLong = new Long[9];
        for (int i = 0; i < 9; i++) {
            arrLong[i] = 0L;
        }
        for (int i = 0; i < arr.length; i++) {
            arrLong[Integer.parseInt(arr[i])]++;
        }


        for (int j = 0; j < days; j++) {
            modify(arrLong);
        }
        return Arrays.stream(arrLong).mapToLong(Long::longValue).sum();
    }

    public static void modify(Long[] result) {
        long temp = result[0];
        for (int i = 0; i < result.length; i++) {
            if (i < 8) {
                if (i == 6) {
                    result[i] = result[i + 1] + temp;
                } else {
                    result[i] = result[i + 1];
                }
            } else {
                result[i] = temp;
            }
        }
    }
}

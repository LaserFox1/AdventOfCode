import tools.ReaderInt;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Day1 {

    int result = 0;
    public static int gaming1(String input) {
        int result = 0;
        System.out.println(Paths.get(input).toAbsolutePath());
        ArrayList<Integer> arr = ReaderInt.read(input);

        for (int i = 0; i < arr.size(); i++) {
            if (i > 0 && arr.get(i) > arr.get(i - 1)) {
                result++;
            }
        }
        return result;
    }

    public static int gaming2(String input) {
        int result = 0;
        int temp = 0;
        ArrayList<Integer> arr = ReaderInt.read(input);

        for (int i = 0; i < arr.size(); i++) {
            if (i + 2 < arr.size()) {
                int p1 = (arr.get(i) + arr.get(i + 1) + arr.get(i + 2));
                if (i > 0 && p1 > temp) {
                    result++;
                }
                temp = p1;
            }
        }
        return result;
    }
}

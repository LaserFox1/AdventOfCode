import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1 {

    public static int gaming(String input) {
        int result = 0;
        System.out.println(Paths.get(input).toAbsolutePath());
        try {
            Scanner s1 = new Scanner(new File(input));
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while (s1.hasNext()) {
                arr.add(Integer.parseInt(s1.nextLine()));
            }
            for (int i = 0; i < arr.size(); i++) {
                if (i > 0 && arr.get(i) > arr.get(i - 1)) {
                    result++;
                }
            }
            s1.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}

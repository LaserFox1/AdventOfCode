package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static ArrayList<Integer> read(String input) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        try {
            Scanner s1 = new Scanner(new File(input));
            while (s1.hasNext()) {
                arr.add(Integer.parseInt(s1.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }
}

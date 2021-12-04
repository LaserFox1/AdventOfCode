import tools.day3.GammaEpsilon;
import tools.day3.OxyCO2;
import tools.ReaderString;
import java.util.ArrayList;
import static tools.day3.Day3Methods.*;

public class Day3 {

    public static GammaEpsilon gaming1(String input) {
        ArrayList<String> arr = ReaderString.read(input);
        int binarySize = arr.get(0).length();
        String gamma = "";
        String epsilon = "";

        for (int i = 0; i < binarySize; i++) {
            String temp = highestBit(arr, i);
            gamma = gamma.concat(temp);
            epsilon = epsilon.concat(String.valueOf((1 - Integer.parseInt(temp))));
        }

        return new GammaEpsilon(gamma, epsilon);
    }

    public static OxyCO2 gaming2(String input) {
        ArrayList<String> arrOxy = ReaderString.read(input), arrCO2 = ReaderString.read(input);
        int binarySize = arrCO2.get(0).length();

        for (int count = 0; count < binarySize; count++) {
            removeItem(arrOxy, count, highestBit(arrOxy, count));
        }
        for (int count = 0; count < binarySize; count++) {
            removeItem(arrCO2, count, lowestBit(arrCO2, count));
        }
        return new OxyCO2(arrOxy.get(0), arrCO2.get(0));
    }
}



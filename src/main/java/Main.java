import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args){
        /*System.out.println(Day1.gaming1("src/main/resources/input1.txt"));
        System.out.println(Day1.gaming2("src/main/resources/input1.txt"));

        System.out.println(Day2.gaming1("src/main/resources/input2.txt"));
        System.out.println(Day2.gaming2("src/main/resources/input2.txt"));

        System.out.println(Day3.gaming1("src/main/resources/input3.txt").result());*/
        long startTime = System.currentTimeMillis();
        System.out.println(Day6.gaming1("src/main/resources/input6.txt",256));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);
    }
}

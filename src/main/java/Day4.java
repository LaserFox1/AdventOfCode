import tools.ReaderString;
import tools.day4.Board;

import java.util.ArrayList;

public class Day4 {
    private static ArrayList<String> arr;
    private static String[] numbers;
    private static int boardsCount;
    private static ArrayList<Board> boards;
    private static String lastNumber;

    public static int gaming1(String input) {
        declaration(input);
        for (String s : numbers) {
            lastNumber = s;
            for (int i = 0; i < boards.size(); i++) {
                boards.get(i).mark(s);
                if (boards.get(i).win()) {
                    return Integer.parseInt(lastNumber) * boards.get(i).Unmarked;
                }
            }
        }

        return 0;
    }

    public static int gaming2(String input) {
        declaration(input);
        ArrayList<Board> winners = new ArrayList<>();
        for (String s : numbers) {
            lastNumber = s;
                for(Board b : boards){
                    b.mark(s);
                    if(b.win()&&!(winners.contains(b))){
                        winners.add(b);
                    }
                    if(winners.size()==boardsCount){
                        return winners.get(boardsCount-1).Unmarked*Integer.parseInt(lastNumber);
                    }
                }
            }

        return 0;
    }
    private static void declaration(String input){
        arr = ReaderString.read(input);
        numbers = arr.get(0).split(",");
        arr.remove(0);
        boardsCount = arr.size() / 6;
        boards = new ArrayList<>(boardsCount);
        lastNumber = "";
        for (int i = 0; i < boardsCount; i++) {
            boards.add(new Board(arr, 5));
        }
    }
}

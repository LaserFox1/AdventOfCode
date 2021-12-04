package tools.day4;

import java.lang.reflect.Array;
import java.util.*;

public class Board {
    private ArrayList<String> PlayBoard;
    private ArrayList<String> MarkedBoard;
    private final int Size;
    public int Unmarked = 0;

    public Board(ArrayList<String> input, int size) {
        input.remove(0);
        this.PlayBoard = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String i0 = input.get(0);
            String s = i0.split("\\s+")[0];

            if (s.equals("")) {
                ArrayList<String> tempList = new ArrayList<String>(Arrays.asList(i0.split("\\s+")));
                tempList.remove(0);
                StringBuilder temp = new StringBuilder();
                for (int k = 0; k < tempList.size(); k++) {
                    String temp2 = tempList.get(k);
                    if (k == 0) {
                        temp.append(temp2);
                    } else {
                        temp.append(" " + temp2);
                    }
                }
                this.PlayBoard.add(temp.toString());
            } else {
                this.PlayBoard.add(input.get(0));
            }
            input.remove(0);
        }
        this.MarkedBoard = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.MarkedBoard.add("-1 -1 -1 -1 -1");
        }
        this.Size = size;
        for (String s : this.PlayBoard) {
            for (String s1 : s.split("\\s+")) {
                if (s1 != "") {
                    this.Unmarked += Integer.parseInt(s1);
                }
            }
        }
    }

    public boolean isMarked(int xpos, int ypos) {
        if (this.MarkedBoard.get(ypos).split("\\s+")[xpos].equals("1")) {
            return true;
        }
        return false;
    }

    public boolean win() {
        ArrayList<Boolean> result = new ArrayList<>(2);
        result.add(Boolean.FALSE);
        result.add(Boolean.FALSE);
        for (int j = 0; j < this.Size; j++) {
            if (MarkedBoard.get(j).equals("1 1 1 1 1")) {
                return true;
            }
        }
        for (int j = 0; j < this.Size; j++) {
            if (this.isMarked(j, 0)
                    && this.isMarked(j, 1)
                    && this.isMarked(j, 2)
                    && this.isMarked(j, 3)
                    && this.isMarked(j, 4)) {
                return true;
            }
        }
        return false;
    }

    public void mark(String value) {
        for (int i = 0; i < this.Size; i++) {
            for (int j = 0; j < this.Size; j++) {
                if (!isMarked(j, i)) {
                    String s = this.PlayBoard.get(i).split("\\s+")[j];
                    if (s.equals(value)) {
                        String[] line = this.MarkedBoard.get(i).split("\\s+");
                        String temp = "";
                        line[j] = "1";
                        for (int k = 0; k < this.Size; k++) {
                            if (k == 0) {
                                temp = temp.concat(line[k]);
                            } else {
                                temp = temp.concat(" " + line[k]);
                            }
                        }
                        this.MarkedBoard.remove(i);
                        this.MarkedBoard.add(i, temp);
                        this.Unmarked -= Integer.parseInt(s);
                    }
                }
            }
        }
    }
}

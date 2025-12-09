import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static int res;
    public static ArrayList<ArrayList<Boolean>> rolls = new ArrayList<ArrayList<Boolean>>();

    public static void addLineToRolls(String line) {
        rolls.add(new ArrayList<Boolean>());
        for (char c : line.toCharArray()) {
            rolls.get(rolls.size()-1).add(c == '@');
        } 
    }

    public static Boolean checkN(int col, int row, int nN) {
        int count = -1; // alow to account for the roll of interest
        for (int c = Math.max(col - 1, 0); c <= Math.min(col + 1, rolls.size() - 1);  c++) {
            for (int r = Math.max(row - 1, 0); r <= Math.min(row + 1, rolls.size() - 1);  r++) {
                if (rolls.get(c).get(r)) count++;
            }
        }
        return(count < nN);
    }

	public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                addLineToRolls(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ArrayList<ArrayList<Boolean>> newRolls = new ArrayList<>();
        for (ArrayList<Boolean> row : rolls) {
            newRolls.add(new ArrayList<>(row));
        }
        int newRes = res;
        while(true) {
            for(int col = 0; col <= rolls.size() - 1; col++) {
                for (int row = 0; row <= rolls.get(col).size() - 1; row++) {
                    if(rolls.get(col).get(row) && checkN(col, row, 4)){
                        newRes++;
                        newRolls.get(col).set(row, false);
                    } 
                }
            }
            rolls = newRolls;
            if (newRes == res) break;
            res = newRes;
        }
        System.out.println(res);
     }
}


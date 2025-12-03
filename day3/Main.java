import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    static long cumsum; 

    public static int findMaxJolt(String bank) {
        String[] splitted = bank.split("");
        int[] jolts = new int[splitted.length];
        int pos1 = 0;
        int pos2 = 0;
        for (int i = 0; i <= splitted.length - 1; i++) {
            jolts[i] = Integer.parseInt(splitted[i]);
        }
        for (int curr = 1; curr <= jolts.length - 2; curr++) {
            if (jolts[curr] > jolts[pos1]) {
                pos1 = curr;
            }
        }
        pos2 = pos1 + 1;
        for (int curr = pos2 + 1; curr <= jolts.length - 1; curr++) {
            if (jolts[curr] > jolts[pos2]) {
                pos2 = curr;
            }
        }
        return(Integer.parseInt("" + jolts[pos1] + jolts[pos2]));
    }

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            while (line != null) {
                cumsum += findMaxJolt(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cumsum);
     }
}


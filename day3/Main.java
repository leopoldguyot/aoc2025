import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static long cumsum; 

    public static String digitsToString(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length);
        for (int x : arr) sb.append(x);
        return sb.toString();
    }
    
    public static int findIndexMax(int[] nums) {
        int maxAt = 0;
        for (int i = 0; i < nums.length; i++) {
            maxAt = nums[i] > nums[maxAt] ? i : maxAt;
        }
        return (maxAt);
    }
    public static long findMaxJoltPart2(String bank) {
        char[] chars = bank.toCharArray();
        int[] jolts = new int[chars.length];
        int[] inds = new int[12];
        int[] res = new int[12];

        for (int i = 0; i < chars.length; i++) {
            jolts[i] = chars[i] - '0';
        }

        int prevStart = 0;

        for (int i = 0; i < 12; i++) {

            int start = prevStart;
            int end = jolts.length - (11 - i);
            int[] slice = Arrays.copyOfRange(jolts, start, end);

            int localIndex = findIndexMax(slice);
            int globalIndex = start + localIndex;

            inds[i] = globalIndex;
            res[i] = jolts[globalIndex];

            prevStart = globalIndex + 1;
        }

        String result = digitsToString(res);
        System.out.println(result);
        return Long.parseLong(result);
    }
 
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
                cumsum += findMaxJoltPart2(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cumsum);
     }
}


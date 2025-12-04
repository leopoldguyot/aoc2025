import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    static long cumsum; 

    public static String digitsToString(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length);
        for (int x : arr) sb.append(x);
        return sb.toString();
    }

    public static int[] removeValueAtIndex(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        int idx = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (i != index) {
                newArr[idx] = arr[i];
                idx++;
            }
        }
        return (newArr);
    }

    public static int findIndexMin(int[] nums) {
        int minAt = 0;
        for (int i = 0; i < nums.length; i++) {
            minAt = nums[i] < nums[minAt] ? i : minAt;
        }
        return (minAt);
    }
    public static long findMaxJoltPart2(String bank) {
        String[] splitted = bank.split("");
        int[] jolts = new int[splitted.length];

        for (int i = 0; i <= splitted.length - 1; i++) {
            jolts[i] = Integer.parseInt(splitted[i]);
        }

        while (jolts.length > 12) {
            jolts = removeValueAtIndex(jolts, findIndexMin(jolts));
        }
        
        System.out.println(digitsToString(jolts));
        return(Long.parseLong(digitsToString(jolts)));
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
            reader = new BufferedReader(new FileReader("input_day3.txt"));
            String line = reader.readLine();
            while (line != null) {
                cumsum += findMaxJolt(line);
                System.out.println(findMaxJolt(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cumsum);
     }
}


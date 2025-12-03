import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    static long cumsum; 
    
    public static boolean checkFake(long num) {
        String strNum = String.valueOf(num);
        int mid = strNum.length() / 2;
        String part1 = strNum.substring(0, mid);
        String part2 = strNum.substring(mid);
        return(part1.equals(part2)); 
    }

    public static boolean checkFakePart2(long num) {
        String s = String.valueOf(num);
        String doubled = s + s;
        String cut = doubled.substring(1, doubled.length() - 1);
        return cut.contains(s);
    }

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            String[] splitted = line.split(",");
            for (String range: splitted) {
                String[] spltRan = range.split("-");
                for(long i = Long.parseLong(spltRan[0]); i <= Long.parseLong(spltRan[1]); i++) {
                    if (checkFakePart2(i)) cumsum += i;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cumsum);
     }
}


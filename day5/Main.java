import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static int res1;
    public static long res2;
    public static ArrayList<Long[]> ranges = new ArrayList<Long[]>();

    public static void addRange(String line) {
        String[] splitLine = line.split("-");
        Long[] numbers = new Long[splitLine.length];
        for(int i = 0;i < splitLine.length;i++)
        {
            numbers[i] = Long.parseLong(splitLine[i]);
        }
        ranges.add(numbers);
    }
    
    public static Boolean checkFresh(String line) {
        long id = Long.parseLong(line);
        for (Long[] ra : ranges) {
            if (id >= ra[0] && id <= ra[1]) return(true);
        }
        return(false);
    }
    
    public static long countUniqueIds(List<Long[]> ranges) {
        ranges.sort(Comparator.comparingLong(a -> a[0]));
        List<Long[]> merged = new ArrayList<>();
        for (Long[] range : ranges) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < range[0] - 1) {
                merged.add(new Long[]{range[0], range[1]});
            } else {
                Long[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], range[1]);
            }
        }

        long total = 0;
        for (Long[] range : merged) {
            total += range[1] - range[0] + 1;
        }
        return total;
    }

	public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            boolean afterEmptyLine = false;
            while (line != null) {
                if (!afterEmptyLine) {
                    if (line.isEmpty()) {
                        afterEmptyLine = true;
                    } else {
                        addRange(line);                           
                    }
                } else {
                    if (checkFresh(line)) res1++;
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        res2 = countUniqueIds(ranges);
        System.out.println("Part1: " + res1);
        System.out.println("Part2: " + res2);
     }
}


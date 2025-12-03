import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static int pos = 50; 
    static int zeros;
    
    public static void movePos(int dist) {
        pos += dist;
        if (pos > 99) {
            zeros++;
            pos -= 100;
        } else if (pos < 0) {
            if (dist != pos) zeros++;
            pos += 100;
        } else if (pos == 0) {
        zeros++;
        }
    }

    static void processLine(String line) {
        int dist = Integer.parseInt(line.substring(1));
        char dir = line.charAt(0);
        zeros+= dist/100;
        dist=dist%100;
        if (dir == 'R') {
            movePos(dist);            
        } else {
            movePos(-dist);
        }

    }

    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();

            while (line != null) {
                processLine(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(zeros);
     }
}

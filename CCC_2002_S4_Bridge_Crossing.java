import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2002_S4_Bridge_Crossing {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int m = readInt();
        int q = readInt();
        String[] names = new String[q];
        int[] times = new int[q];
        for(int i = 0; i < q; i++){
            names[i] = readLine();
            times[i] = readInt();
        }
        ArrayList<Integer> groupTimes = new ArrayList<Integer>();
        groupTimes.add(times[0]);
        for(int i = 2; i < q; i++){
            if(groupTimes.get(groupTimes.size()-1) + times[i] > times[i]){
                
            }
        }
        

        
    }
 
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken(); // reading next
        }

        static int readInt() throws IOException {
        return Integer.parseInt(next()); // reading an int
        }

        static double readDouble() throws IOException {
        return Double.parseDouble(next()); // reading a double
        }

        static char readCharacter() throws IOException {
        return next().charAt(0); // reading the character
        }

        static String readLine() throws IOException {
        return br.readLine().trim(); // reading a line
        }
}

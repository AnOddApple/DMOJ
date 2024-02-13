import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.*;

public class NOI_2000_P1_Ceramic_Necklace {
    // https://dmoj.ca/problem/noi00p1
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        DecimalFormat df = new DecimalFormat("0.0000000");
        double vTot = readDouble();
        double v0 = readDouble();
        double maxLength = -1;
        int optiNumDisks = 0;
        double length = 0;
        int repCount = 0;
        // number of disks produced just before V <= Vo
        // V = Vt/Vo = num
        for(int i = 1; i <= (int)vTot/v0; i++){
            length = Double.valueOf(df.format(i*(0.3 * Math.sqrt(vTot/i - v0))));
            if(length > maxLength) {
                maxLength = length;
                optiNumDisks = i;
            }
            else if(length == maxLength){
                repCount++;
            }
        }
        if(repCount >= 1) System.out.println("0");
        else if(maxLength == 0) System.out.println("0");
        else System.out.println(optiNumDisks);
        
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

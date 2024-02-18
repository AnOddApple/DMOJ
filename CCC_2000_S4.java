import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2000_S4 {
    //https://dmoj.ca/problem/ccc00s4
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main (String[] args) throws IOException{
        int distance = readInt();
        int numClubs = readInt();
        int[] powers = new int[numClubs];
        int minPower = 101;
        for(int i = 0; i < numClubs; i++){
            powers[i] = readInt();
            minPower = Math.min(minPower, powers[i]);
        }
        int[] possibleIn = new int[5281];
        for(int i = 0; i <= 5280; i++){
            possibleIn[i] = 999999;
        }
        for(int j : powers){
            possibleIn[j] = 1;
        }
        for(int i = minPower; i <= 5280; i++){
            for(int j : powers){
                if(i+j <= 5280) possibleIn[i+j] = Math.min(possibleIn[i] + 1, possibleIn[i+j]);
            }
        }
        if(possibleIn[distance] < 999999) System.out.println("Roberta wins in " + possibleIn[distance] + " strokes.");
        else System.out.println("Roberta acknowledges defeat.");

        
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

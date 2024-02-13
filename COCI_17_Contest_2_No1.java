import java.util.*;
import java.io.*;
public class COCI_17_Contest_2_No1 { 
//COCI '17 Contest 2 #1 Košnja
// https://dmoj.ca/problem/coci17c2p1
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int k = readInt();
        for(int i = 0; i < k; i++){
            int n = readInt();
            int m = readInt();
            int w = 0;
            if(n > m) {
                w = m;
            }
            else {
                w = n;
            }
            int numTurns = w*2-2;
            System.out.println(numTurns);
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

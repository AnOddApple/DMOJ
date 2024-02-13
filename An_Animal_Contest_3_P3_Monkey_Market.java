import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class An_Animal_Contest_3_P3_Monkey_Market {
    //https://dmoj.ca/problem/aac3p3
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = readInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++){
            prices[i] = readInt();
        }
        Arrays.sort(prices);
        int[][] pairs = new int[n/2][2];
        if(n%2 == 0){
            for(int i = 0; i < n/2; i++){
                pairs[i][0] = prices[i];
                pairs[i][1] = prices[n-i-1];
            }
            for(int i = n/2-1; i >= 0; i--){
                System.out.print(pairs[i][0] + " ");
                if(i != 0) System.out.print(pairs[i][1] + " ");
                else System.out.print(pairs[i][1]);
            }
            System.out.println();
            boolean isB = true;
            for(int i = 0; i < n; i++){
                if(isB) {
                    System.out.print("B");
                    isB = false;
                }
                else {
                    System.out.print("S");
                    isB = true;
                }
            }

        }
        else if(n%2 == 1){
            for(int i = 0; i < n/2; i++){
                pairs[i][0] = prices[i];
                pairs[i][1] = prices[n-i-1];
            }
            System.out.print(prices[n/2] + " ");
            for(int i = n/2-1; i >= 0; i--){
                System.out.print(pairs[i][0] + " ");
                if(i != 0) System.out.print(pairs[i][1] + " ");
                else System.out.print(pairs[i][1]);
                
            }
            boolean isB = true;
            System.out.println();
            System.out.print("E");
            for(int i = 0; i < n-1; i++){
                if(isB) {
                    System.out.print("B");
                    isB = false;
                }
                else {
                    System.out.print("S");
                    isB = true;
                }
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
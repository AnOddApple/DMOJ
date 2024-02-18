import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2015_S3_Gates {
    //https://dmoj.ca/problem/ccc15s3
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] nextAvailable = new int[(int)Math.pow(10,5)+2];
    static int G;
    public static int findLocation (int g, boolean[] gates){
        if(g == -1) return -1;
        if(!gates[g]) {
            if(G >= 1){
                if(nextAvailable[G-1] == -2){
                  nextAvailable[G] = g-1;
                }
                else nextAvailable[G] = nextAvailable[G-1];
            }
            else nextAvailable[0] = -1;
            return g;
        }
        if(nextAvailable[g] != -2) {
            int x = findLocation(nextAvailable[g], gates);  
            nextAvailable[G] = x; 
            return x;
        }
        // 1 1 0 0 0 0
        // 2 2 3 3 4 4  
        // nextAvailable  0 -1 2 0 0 0 
        /*
         * 5
         * 4
         * 1
         * 3
         * 2
         * 3
         */
        //it is possible for something to be marked true even though its nextAvailable index is -2
        return findLocation(g-1, gates);
    }
    public static void main (String[] args) throws IOException{
        Arrays.fill(nextAvailable, -2);
        int g = readInt();
        int p = readInt();
        int numP = 0;
        int[] requests = new int[p];
        for(int i = 0; i < p; i++){
            requests[i] = readInt()-1;
        }
        boolean[] gates = new boolean[g];
        Arrays.fill(gates, false);
        for(int i : requests){
            System.out.println("Processing Plane that docks from 1-" + (i+1) + ", g = " + i);
            G = i;
            int x = findLocation(i, gates);
            if(x == -1) break;
            else {
                gates[x] = true;
                numP++;
            }
            for(boolean y:gates){
                if(y) System.out.print("X");
                else System.out.print("O");
            }
            System.out.println();
            for(int a = 0; a < g; a++){
                System.out.print(nextAvailable[a] + " ");
            }
            System.out.println();
        }
        for(int a = 0; a < g; a++){
            System.out.print(nextAvailable[a] + " ");
        }
        System.out.println();
        System.out.println(numP);



        
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

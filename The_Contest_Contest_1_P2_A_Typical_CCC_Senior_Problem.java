import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class The_Contest_Contest_1_P2_A_Typical_CCC_Senior_Problem {
    //https://dmoj.ca/problem/tcc1p2
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = readInt();
        int K = readInt();
        int [] list = new int[n];
        int [] dVals = new int[K];
        for(int i = 0; i < n; i++){
            list[i] = readInt();   
        }
        for(int i = 0; i < K; i++){
            dVals[i] = readInt();
        }
        long [] PSA = new long[n+1];
        PSA[0] = 0;
        HashMap<Integer, ArrayList<Integer>> numOccurLoc = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = n-1; i >= 0; i--){
            numOccurLoc.putIfAbsent(list[i], new ArrayList<Integer>());
            numOccurLoc.get(list[i]).add(i);
        }
        for(int i = 0; i < n; i++){
            PSA[i+1] = PSA[i] + list[i];
        }
        
        for(int i = 1; i <= K; i++){
            int d = dVals[i-1];
            long sum = 0;
            int lPtr = n-1;
            if(numOccurLoc.containsKey(i)){
                for(int j : numOccurLoc.get(i)){
                    if(lPtr <= 0) break;
                    if(lPtr == n-1 && j != lPtr){
                        sum += PSA[n] - PSA[j+1];
                        lPtr = j-d;
                    }
                    else if(lPtr == j+1){
                        lPtr = lPtr-d-1;
                    }
                    else if(lPtr == j && j == n-1){
                        lPtr = lPtr-d;
                    }
                    else if(lPtr > j){
                        sum += PSA[lPtr] - PSA[j+1];
                        lPtr = j-d;
                    }
                    else if(lPtr <= j){
                        lPtr = lPtr-d-1;
                    }
                }
                if(lPtr > 0) {
                    sum += PSA[lPtr];
                }
                System.out.println(sum);
            }
            else System.out.println(PSA[n]);
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


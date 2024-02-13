import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Woburn_Challenge_2002_P8_Deploying_Troops{
    //https://dmoj.ca/problem/wc02p8
    //DOES NOT WORK (I THINK)
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int numCows = readInt();
        int[] cowVals = new int[numCows];
        for(int i = 0; i < numCows; i++){
            cowVals[i] = readInt();
        }
        int numTests = readInt();
        int[] targets = new int[numTests ];
        for(int i = 0; i < numTests; i++){
            targets[i] = readInt();
        }
        int[] targetsMet = new int[numTests];
        for(int i = 0; i < numTests; i++){
            targetsMet[i] = 0;
        }
        int[] prefixSum = new int[numCows+1];
        prefixSum[0] = 0;
        for(int i = 1; i < numCows+1; i++){
            prefixSum[i] = prefixSum[i-1] + cowVals[i-1];
        }
        for(int a = 0; a < numTests; a++){
            int totalCount = 0;
            int target = targets[a];
            for(int i = 0; i < numCows; i++){
                for(int k = 1; k < numCows+1; k++){
                    int val = prefixSum[k]-prefixSum[i];
                    if(val > target) {
                        i++;
                        k = 1;
                    }
                    else if(val == target){
                        totalCount++;
                    }
                }
            }
            System.out.print(totalCount + " ");
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

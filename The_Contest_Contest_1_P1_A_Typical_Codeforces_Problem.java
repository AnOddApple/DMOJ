import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class The_Contest_Contest_1_P1_A_Typical_Codeforces_Problem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = readInt();
        String voteString = readLine();
        char[] votes = new char[n];
        int nos = 0;
        int yes = 0;
        HashSet<Integer> cValues = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            votes[i] = voteString.charAt(i);
            if(votes[i] == 'N') nos++;
            else {
                yes++;
                cValues.add(yes);
            }
        }
        boolean operationPerformed = true;
        while(nos >= yes && operationPerformed){
            operationPerformed = false;
            for(int i = 0; i < n; i++){
                if(cValues.contains(i+1) && votes[i] == 'N'){
                    operationPerformed = true;
                    votes[i] = 'Y';
                    yes++;
                    nos--;
                    cValues.add(yes);
                }
            }
        }
        if(nos >= yes) System.out.println("NO");
        else System.out.println("YES");
        
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

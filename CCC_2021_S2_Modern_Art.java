import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2021_S2_Modern_Art {
    //https://dmoj.ca/problem/ccc21s2
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int m = readInt();
        int n = readInt();
        int k = readInt();
        char[] charChoices = new char[k];
        int[] choiceDat = new int[k];
        for(int i = 0; i < k; i++){
            charChoices[i] = readCharacter();
            choiceDat[i] = readInt();
        }
        int[] rowFreq = new int[m];
        int[] colFreq = new int[n];
        long numGolds = 0;
        for(int i = 0; i < k; i++){
            if(charChoices[i] == 'C'){
                colFreq[choiceDat[i]-1]++;
            }
            else if(charChoices[i] == 'R'){
                rowFreq[choiceDat[i]-1]++;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((colFreq[j] + rowFreq[i])%2==1) numGolds++;
            }
        }
        System.out.println(numGolds);
        
        
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

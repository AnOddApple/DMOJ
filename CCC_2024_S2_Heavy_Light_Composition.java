import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2024_S2_Heavy_Light_Composition {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int t = readInt();
        int n = readInt();
        char[][] seqs = new char[t][n];
        HashMap<Integer, HashSet<Character>> heavies = new HashMap<Integer, HashSet<Character>>();
        HashMap<Integer, HashSet<Character>> lights = new HashMap<Integer, HashSet<Character>>();
        for(int i = 0; i < t; i++){
            String in = readLine();
            lights.putIfAbsent(i, new HashSet<Character>());
            heavies.putIfAbsent(i, new HashSet<Character>());
            for(int j = 0; j < n; j++){
                seqs[i][j] = in.charAt(j);
                if(lights.get(i).contains((in.charAt(j)))){
                    heavies.get(i).add(in.charAt(j));
                }
                else {
                    lights.get(i).add(in.charAt(j));
                }
            }
        }   
        for(int i = 0; i < t; i++){
            boolean isAlternating = true;
            boolean needHeavy;
            if(heavies.get(i).contains(seqs[i][0])){
                needHeavy = false;
            }
            else needHeavy = true;
            for(int j = 1; j < n; j++){
                if(needHeavy && !heavies.get(i).contains(seqs[i][j])){
                    isAlternating = false;
                    break;
                }
                else if(!needHeavy && heavies.get(i).contains(seqs[i][j])){
                    isAlternating = false;
                    break;
                }
                else needHeavy = !needHeavy;
            }
            if(isAlternating) System.out.println("T");
            else System.out.println("F");
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

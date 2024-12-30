import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2024_S3_Alternate {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = readInt();
        int[] a = new int[n];
        int[] b = new int[n];
        HashMap<Integer, ArrayList<Integer>> numOccurs = new HashMap<Integer, ArrayList<Integer>>();
        boolean[] unchangeable = new boolean[n];
        for(int i = 0; i < n; i++){
            a[i] = readInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = readInt();
            if(a[i] == b[i]) unchangeable[i] = true;
            numOccurs.putIfAbsent(a[i], new ArrayList<Integer>());
            numOccurs.get(a[i]).add(i);
        }
        ArrayList<Character> operations = new ArrayList<Character>();
        ArrayList<Integer> operDet1 = new ArrayList<Integer>();
        ArrayList<Integer> operDet2 = new ArrayList<Integer>();
        boolean isPossible = true;
        boolean operationPerformed = true;
        while(operationPerformed){
            operationPerformed = false;
            for(int i = 0; i < n; i++){
                if(a[i] != b[i]){ //if number does not match
                    int minDistance = 999999999;
                    int minLoc = -1;
                    boolean isPossibleDown = false;
                    boolean isPossibleUp = false;
                    for(int j = i; j >= 0; j--){
                        if(a[j] == b[i]){
                            isPossibleDown = true;
                            if(minDistance > Math.abs(j-i)) {
                                minDistance = Math.abs(j-i);
                                minLoc = j;
                            }
                            break;
                        }
                        else if(unchangeable[j]){
                            break;
                        }
                    }
                    for(int j = i; j < n; j++){
                        if(a[j] == b[i]){
                            isPossibleUp = true;
                            if(minDistance > Math.abs(j-i)) {
                                minDistance = Math.abs(j-i);
                                minLoc = j;
                            }
                            break;
                        }
                        else if(unchangeable[j]){
                            break;
                        }
                    }
                    if(isPossibleUp && minLoc > i){
                        operations.add('L');
                        operDet1.add(i);
                        operDet2.add(minLoc);
                        for(int top = minLoc; top >= i; top--){
                            a[top] = a[minLoc];
                            if(a[top] == b[top]) unchangeable[top] = true;
                        }
                        operationPerformed = true;
                    }
                    else if(isPossibleDown && minLoc < i){
                        operDet1.add(minLoc);
                        operDet2.add(i);
                        operations.add('R');
                        for(int bot = minLoc; bot <= i; bot++){
                            a[bot] = a[minLoc];
                            if(a[bot] == b[bot]) unchangeable[bot] = true;
                        }
                        operationPerformed = true;
                    }
                    else {
                        isPossible = false;
                        operationPerformed = false;
                        break;
                    }
                }
            }
        }
        if(isPossible){
            System.out.println("YES");
            System.out.println(operations.size());
            for(int i = 0; i < operations.size(); i++){
                System.out.print(operations.get(i) + " ");
                System.out.print(operDet1.get(i) + " ");
                System.out.println(operDet2.get(i));
            }
        }
        else System.out.println("NO");

        
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

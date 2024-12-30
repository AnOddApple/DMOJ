import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2024_S3_Swipe {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = readInt();
        int[] a = new int[n];
        int[] b = new int[n];
        ArrayList<Character> operations = new ArrayList<Character>();
        ArrayList<Integer> operDet1 = new ArrayList<Integer>();
        ArrayList<Integer> operDet2 = new ArrayList<Integer>();
        ArrayList<Integer> orderNeeded = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            a[i] = readInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = readInt();
            if(i == 0) orderNeeded.add(b[i]);
            else {
                if(b[i-1] != b[i]) orderNeeded.add(b[i]);
            }
        }
        int[] numOccurs = new int[orderNeeded.size()];
        int index = 0;
        boolean isPossible = false;
        for(int i = 0; i < n; i++){
            if(index < orderNeeded.size()){
                if(a[i] == orderNeeded.get(index)) {
                    numOccurs[index] = i; //numOccurs[i] where i is the ith number needed will get you first location of i
                    index++;
                }
            }
            else if(index == orderNeeded.size()){
                isPossible = true;
                break;
            }
        }
        if(index == orderNeeded.size()) isPossible = true;
        for(int i = 0; i < numOccurs.length; i++){
            if(i == 0){
                boolean operationPerformed = false;
                for(int j = 0; j < numOccurs[i]; j++){
                    a[j] = a[numOccurs[i]];
                    operationPerformed = true;
                }
                if(operationPerformed) {
                operations.add('L');
                operDet1.add(0);
                operDet2.add(numOccurs[i]);
                }   
            }
            else if(i == numOccurs.length-1){
                boolean operationPerformed = false;
                for(int j = numOccurs[i]; j < n; j++){
                    a[j] = a[numOccurs[i]];
                    operationPerformed = true;
                }
                if(operationPerformed) {
                    operations.add('R');
                    operDet1.add(numOccurs[i]);
                    operDet2.add(numOccurs.length);
                }
            }
            else {
                boolean operationPerformed = false;
                for(int j = numOccurs[i]; j >= 0; j--){
                    if(a[numOccurs[i]] == b[j]) {
                        a[j] = a[numOccurs[i]];
                        operationPerformed = true;
                    }
                    else {
                        if(operationPerformed){
                            operations.add('L');
                            operDet1.add(j+1);
                            operDet2.add(numOccurs[i]);
                        }
                    }
                }
            }
        }
        for(int i = 1; i < n; i++){
            if(a[i] != b[i]) {
                if(a[i-1] == b[i]){
                    operations.add('R');
                    operDet1.add(i-1);
                    operDet2.add(i);
                    a[i] = a[i-1];
                }
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(a[i] != b[i]) {
                if(a[i+1] == b[i]){
                    operations.add('L');
                    operDet1.add(i+1);
                    operDet2.add(i);
                    a[i] = a[i+1];
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

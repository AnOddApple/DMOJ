import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC_2012_S3_Absolutely_Acidic {
    //https://dmoj.ca/problem/ccc12s3
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static long[] sort (long[] freqs){
        boolean isSwapped = true;
        while(isSwapped){
            isSwapped = false;
            for(int i = 0; i < freqs.length-1; i++){
                if(freqs[i+1]%10000000 > freqs[i]%10000000){
                    isSwapped = true;
                    long temp = freqs[i+1];
                    freqs[i+1] = freqs[i];
                    freqs[i] = temp;
                }
            }
        }
        return freqs;
    }
    public static void main (String[] args) throws IOException{
        int n = readInt();
        long[] freqs = new long[1000];
        for(int i = 0; i < 1000; i++){
            freqs[i] = (long)Math.pow(10,7)*(i+1);
        }
        for(int i = 0; i < n; i++){
            freqs[readInt()-1]++;
        }
        freqs = sort(freqs);
        for(int i = 0; i < freqs.length; i++){
            System.out.println(freqs[i]);
        }
        int freqsWithLargestFreq = 1;
        int freqsWithSecondFreq = 1;
        boolean onSecond = false;
        for(int i = 0; i < freqs.length-1; i++){
            if(freqs[i+1]%10000000 == freqs[i]%10000000 && !onSecond) {
                freqsWithLargestFreq++;
            }
            else if(freqs[i+1]%10000000 != freqs[i]%10000000 && !onSecond){
                onSecond = true;
            }
            else if(freqs[i+1]%10000000 == freqs[i]%10000000 && onSecond){
                freqsWithSecondFreq++;
            }
            else break;
        }
        System.out.println("freqsWithLargestFreq: " + freqsWithLargestFreq);
        System.out.println("freqsWithSecondFreq: " + freqsWithSecondFreq);
        if(freqsWithLargestFreq == 1 && freqsWithSecondFreq == 1 || freqsWithLargestFreq == 2){
            System.out.println(Math.abs(freqs[0]/10000000-freqs[1]/10000000));
        }
        else if(freqsWithLargestFreq > 2){
            long maxReading = 0;
            long minReading = 9999999;
            for(int i = 0; i < freqsWithLargestFreq; i++){
                if(freqs[i]/10000000 > maxReading) maxReading = freqs[i]/10000000;
                if(freqs[i]/10000000 < minReading) minReading = freqs[i]/10000000;
            }
            System.out.println(Math.abs(maxReading-minReading));
        }
        else if(freqsWithLargestFreq == 1 && freqsWithSecondFreq >= 2){
            long maxReading = 0;
            long minReading = 9999999;
            for(int i = 1; i < freqsWithSecondFreq+1; i++){
                if(freqs[i]/10000000 < minReading) minReading = freqs[i]/10000000;
                if(freqs[i]/10000000 > maxReading) maxReading = freqs[i]/10000000;
            }
            if(Math.abs(maxReading-freqs[0]/10000000) > Math.abs(minReading-freqs[0]/10000000)) System.out.println(Math.abs(freqs[0]/10000000-maxReading));
            else System.out.println(Math.abs(freqs[0]/10000000-minReading));
        }
        else System.out.println(Math.abs(freqs[0]/10000000-freqs[1]/10000000));


        
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

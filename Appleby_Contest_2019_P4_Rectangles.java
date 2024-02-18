import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Appleby_Contest_2019_P4_Rectangles{
    //https://dmoj.ca/problem/ac19p4
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main (String[] args) throws IOException{
        int n = readInt();
        int[][] points = new int[n][2];
        for(int i = 0; i < n; i++){
            points[i][0] = readInt();
            points[i][1] = readInt();
        }
        int maxArea = 0;
        for(int[] i : points){
            for(int[] j : points){
                int[] corner1 = {i[0], j[1]};
                int[] corner2 = {j[0], i[1]};
                boolean is1 = false;
                boolean is2 = false;
                for(int[] k : points){
                    if(corner1[0] == k[0] && corner1[1] == k[1]){
                        is1 = true;
                    }
                    if(corner2[0] == k[0] && corner2[1] == k[1]){
                        is2 = true;
                    }
                }
                if(is1 && is2) maxArea = Math.max(maxArea, Math.abs(corner1[0] - corner2[0]) * Math.abs(corner1[1] - corner2[1]));
            }
        }
        System.out.println(maxArea);
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

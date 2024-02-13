import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Rat_In_A_Maze {
// https://dmoj.ca/problem/ratmaze
// this is the version that shows the user the dfs being done in real time
// hapi b/c first time doing dfs
// for dmoj version, remove mazeVisual variable and the printing of anything other than yes or no
public static void clearScreen() {
    System.out.print("\033\143");
  }   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static boolean dfs (int n, int[][] maze){
        Stack<Integer> toVisit = new Stack<Integer>();
        boolean [][] visited = new boolean[n][n];
        int[][] mazeVisual = maze.clone();
        for(int i = 0 ; i < n; i++){
            for(int k = 0; k < n; k++){
                visited[i][k] = false;
            }
        }
        int y = 0;
        int x = 0;
        visited[0][0] = true;
        int count = 2;
        do {
            count++;
            if(x == 0 && y == 0){
                if(maze[y][x+1] == 0 && !visited[y][x+1]) toVisit.push(1);
                if(maze[y+1][x] == 0 && !visited[y+1][x]) toVisit.push(n);
            }
            else if(x == 0 && y == n-1){
                if(maze[y][x+1] == 0 && !visited[y][x+1]) toVisit.push(y*n+x+1);
                if(maze[y-1][x] == 0 && !visited[y-1][x]) toVisit.push((y-1)*n+x);
            }
            else if(x == n-1 && y == 0){
                if(maze[y][x-1] == 0 && !visited[y][x-1]) toVisit.push(y*n+x-1);
                if(maze[y+1][x] == 0 && !visited[y+1][x]) toVisit.push((y+1)*n+x);
            }
            else if(y == 0){
                if(maze[y][x+1] == 0 && !visited[y][x+1]) toVisit.push(x+1);
                if(maze[y][x-1] == 0 && !visited[y][x-1]) toVisit.push(x-1);
                if(maze[y+1][x] == 0 && !visited[y+1][x]) toVisit.push(n+x);
            }
            else if(x == 0) {
                if(maze[y][x+1] == 0 && !visited[y][x+1]) toVisit.push(y*n+1);
                if(maze[y-1][x] == 0 && !visited[y-1][x]) toVisit.push((y-1)*n);
                if(maze[y+1][x] == 0 && !visited[y+1][x]) toVisit.push((y+1)*n);
            }
            else if(x == n-1){
                if(maze[y][x-1] == 0 && !visited[y][x-1]) toVisit.push(y*n+x-1);
                if(maze[y+1][x] == 0 && !visited[y+1][x]) toVisit.push((y+1)*n + x);
                if(maze[y-1][x] == 0 && !visited[y-1][x]) toVisit.push((y-1)*n + x);
            }
            else if(y == n-1){
                if(maze[y][x+1] == 0 && !visited[y][x+1]) toVisit.push(y*n+x+1);
                if(maze[y][x-1] == 0 && !visited[y][x-1]) toVisit.push(y*n+x-1);
                if(maze[y-1][x] == 0 && !visited[y-1][x]) toVisit.push((y-1)*n + x);
            }
            else {
                if(maze[y][x+1] == 0 && !visited[y][x+1]) toVisit.push(y*n+x+1);
                if(maze[y][x-1] == 0 && !visited[y][x-1]) toVisit.push(y*n+x-1);
                if(maze[y+1][x] == 0 && !visited[y+1][x]) toVisit.push((y+1)*n+x);
                if(maze[y-1][x] == 0 && !visited[y-1][x]) toVisit.push((y-1)*n+x);
            }
            if(toVisit.empty()){
                if(visited[n-1][n-1]) return true;
                else return false;
            }
            x = (toVisit.peek())%n;
            y = (toVisit.peek())/n;
            toVisit.pop();
            visited[y][x] = true;
            mazeVisual[y][x] = count;
            for(int z = 0; z < n; z++){
                for(int k = 0; k < n; k++){
                    System.out.print(mazeVisual[z][k] + "\t");
                }
                System.out.println();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            clearScreen();
            System.out.println();
            if(visited[n-1][n-1]) return true;
        } while(true);

    }
    public static void main (String[] args) throws IOException{
       int n = readInt();
       int [][] maze = new int[n][n];
       for(int i = 0; i < n; i++){
        for(int k = 0; k < n; k++){
            maze[i][k] = readInt();
        }
       }
        boolean isSolvable = dfs(n, maze);
        if(isSolvable) System.out.println("yes");
        else System.out.println("no");
        
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

/*
    10
    0  1  0  1  0  0  0  1  0  1
    0  1  1  1  0  0  1  1  0  0
    0  1  1  0  0  1  1  0  0  1
    0  0  1  0  1  0  0  1  1  1
    1  0  0  0  0  0  0  1  1  0
    0  1  0  1  0  1  0  1  0  1
    1  1  1  0  0  1  0  0  0  1
    0  1  0  1  0  0  0  1  0  0
    1  0  0  1  1  1  0  0  1  0
    1  1  0  1  1  1  0  0  1  0

 */
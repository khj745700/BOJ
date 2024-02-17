import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int total;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        arr = new int[9][9];
        visited = new boolean[9][9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< 9; i++) {
            String input = br.readLine();
            for(int j = 0 ; j < 9; j++) {
                arr[i][j] = input.charAt(j) - '0';
                if(arr[i][j] == 0) {
                    total++;
                    visited[i][j] = true;
                }
            }
        }
        backtracking(0,0);
        for(int i = 0; i < 9; i++) {
            for(int j = 0 ; j < 9; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }


    static boolean backtracking(int depth, int cnt) {
        if(depth == 81) {
            return true;
        }

            int x = depth % 9;
            int y =  depth / 9;
            if(!visited[y][x]) {
                return backtracking(depth+1, cnt);
            }
            for(int j = 1 ; j <= 9; j++) {
                if(h(x,y,j) && v(x,y,j) && square(x,y,j)){
                    arr[y][x] = j;
                    if(backtracking(depth+1, cnt+1)) {
                        return true;
                    }
                    arr[y][x] = 0;
                }
            }
        return false;
    }



    static boolean h(int x, int y, int val) {
        for(int i = 0; i < 9; i++) {
            if(arr[y][i] == val) {
                return false;
            }
        }
        return true;
    }

    static boolean v(int x, int y, int val) {
        for(int i = 0; i < 9; i++) {
            if(arr[i][x] == val) {
                return false;
            }
        }
        return true;
    }

    static boolean square(int x, int y, int val) {
        for(int i = (x/3)*3 ; i < (x/3)*3+3; i++) {
            for(int j = (y/3)*3; j < (y/3)*3+3; j++){
                if(arr[j][i] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
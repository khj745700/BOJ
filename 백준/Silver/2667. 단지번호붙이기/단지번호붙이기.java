import java.io.*;
import java.util.*;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int stoi(String s) {return Integer.parseInt(s);}
    static List<Integer> hosu = new ArrayList<>();
    static int N;
    static int[][] map;

    static int[] dx = {0, 0, -1, 1}; //상,하,좌,우
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        N = stoi(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for(int j = 0 ; j < N; j++) {
                map[i][j] = temp[j] - '0';
            }
        }

        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N; j++) {
                int count = DFS(i, j);
                if (count != 0) {
                    hosu.add(count);
                }
            }
        }

        Collections.sort(hosu);
        System.out.println(hosu.size());
        for (int count : hosu) {
            System.out.println(count);
        }
    }


    static int DFS(int y, int x) {
        if(map[y][x] == 0) {
            return 0;
        }
        map[y][x] = 0;
        int count = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curY = cur[0];
            int curX = cur[1];
            ++count;
            for(int i = 0; i < 4; i++) {
                int dX = dx[i] + curX;
                int dY = dy[i] + curY;
                if(dX < 0 || dX >= N || dY < 0 || dY >= N) {
                    continue;
                }
                if(map[dY][dX] == 1) {
                    queue.add(new int[]{dY, dX});
                    map[dY][dX] = 0;
                }
            }
        }
        return count;
    }

}

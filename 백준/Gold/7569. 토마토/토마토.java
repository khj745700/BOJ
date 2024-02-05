import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    static int X, Y, Z;
    static int[][][] map;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int remain = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = stoi(st.nextToken());
        Y = stoi(st.nextToken());
        Z = stoi(st.nextToken());
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> next = new ArrayDeque<>();
        Queue<int[]> temp;
        map = new int[Z][Y][X];
        for(int k = 0 ; k < Z; k++) {
            for(int i = 0 ; i < Y; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < X; j++) {
                    map[k][i][j] = stoi(st.nextToken());
                    if(map[k][i][j] == 0){
                        remain++;
                    }
                    if(map[k][i][j] == 1) {
                        q.add(new int[]{i,j,k});
                    }
                }
            }
        }

        int count = 0;

        while(remain > 0) {
            BFS(q, next);
            count++;
            if(count > X * Y * Z) {
                count = -1;
                break;
            }
            temp = q;
            q = next;
            next = temp;
        }

        System.out.println(count);
    }

    static void BFS(Queue<int[]> q, Queue<int[]> next) {

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[1];
            int y = cur[0];
            int z = cur[2];

            for(int i = 0 ; i < 6; i++) {
                int dX = x + dx[i];
                int dY = y + dy[i];
                int dZ = z + dz[i];
                if(dX < 0 || dX >= X || dY < 0 || dY >= Y || dZ < 0 || dZ >= Z) {
                    continue;
                }
                if(map[dZ][dY][dX] == -1) {
                    continue;
                }

                if(map[dZ][dY][dX] == 0) {
                    map[dZ][dY][dX] = map[z][y][x] + 1;
                    next.add(new int[]{dY, dX, dZ});
                    remain--;
                }
            }
        }
    }
}

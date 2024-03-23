import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Integer[][] visited = new Integer[N][M];
        List<int[]> nextQ = new ArrayList<>();
        int count = 0;

        q.add(new int[]{0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0 ; i <4 ; i++) {
                int curX = cur[0] + dx[i];
                int curY = cur[1] + dy[i];
                if(isNotBoundary(curX, curY)) {
                    continue;
                }

                if(arr[curY][curX] == 0 && visited[curY][curX] == null) {
                    q.add(new int[]{curX, curY});
                    visited[curY][curX] = 0;
                    continue;
                }

                if(arr[curY][curX] == 1 && visited[curY][curX] == null) {
                    visited[curY][curX] = 1;
                    continue;
                }

                if(arr[curY][curX] == 1 && visited[curY][curX] == 1) {
                    visited[curY][curX] = 2;
                    nextQ.add(new int[]{curX, curY});
                }
            }
            if(q.isEmpty() && !nextQ.isEmpty()) {
                count++;
                for(int[] curs : nextQ) {
                    arr[curs[1]][curs[0]] = 0;
                }
                q.addAll(nextQ);
                nextQ.clear();
            }
        }

        return count;
    }
    static void print() {
        for(int i = 0 ; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }

    static boolean isNotBoundary(int x, int y) {
        return x == -1 || x == M || y == -1 || y == N;
    }
}


import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static long bitMasking;
    static long cantGo;
    static int[][] map;
    static List<int[]> viruses;
    static int totalCount;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        viruses = new ArrayList<>();
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1 || map[i][j] == 2) {
                    cantGo += 1L << (i * M + j);
                }

                if(map[i][j] == 0) {
                    totalCount++;
                }

                if(map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        backTracking(0, 0);

        System.out.println(max);
    }


    static void backTracking(int cnt, int start) {
        if(cnt == 3) {
        // bfs 탐색 후 값 비교
            max = Math.max(bfs() - 3, max);
            return;
        }

        //비트마스킹 작업 및 배열에도 값 저장
        for(int i = start; i < N * M; i++) {
            //방문했거나 갈 수 없는 곳이라면
            if((bitMasking & 1L << i) != 0 || (cantGo & 1L << i) != 0) {
                continue;
            }

            bitMasking += 1L << i;

            map[i / M][i % M] = 1;
            backTracking(cnt+1, i + 1);
            bitMasking -= 1L << i;
            map[i / M][i % M] = 0;
        }
    }


    static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        int ans = 0;
        for(int[] virus : viruses) {
            q.add(virus);
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int y = cur[0];
                int x = cur[1];
                if(visited[y][x]) {
                    continue;
                }

                visited[y][x] = true;
                ans ++;
                for(int i = 0; i < 4; i++) {
                    int curX = dx[i] + x;
                    int curY = dy[i] + y;
                    if(!isBoundary(curX, curY)) {
                        continue;
                    }

                    if(map[curY][curX] == 0) {
                        q.add(new int[]{curY, curX});
                    }
                }
            }
        }
        //사용가능한 방의 개수
        return totalCount - ans + viruses.size();
    }

    static boolean isBoundary(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }

}

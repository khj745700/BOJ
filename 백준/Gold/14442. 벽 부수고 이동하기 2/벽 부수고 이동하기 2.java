
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] map;
    static int N, M, K;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new int[K+1][N][M];

        String str;
        for(int i = 0 ; i < N; i++) {
            str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) == '1' ? false : true;
            }
        }
//        for(int i = 0 ; i < 2; i++){
//            for(int j = 0 ; j < N; j++) {
//                System.out.println(Arrays.toString(visited[i][j]));
//            }
//            System.out.println();
//        }
        System.out.println(bfs());
    }



    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,1,0));

        int curX;
        int curY;
        Node cur;
        while(!q.isEmpty()) {
            cur = q.poll();

            if(cur.brokenCount > K) {
                continue;
            }

            if(visited[cur.brokenCount][cur.y][cur.x] != 0) {
                continue;
            }

            if(cur.y == N-1 && cur.x == M-1 ) {
                return cur.weight;
            }

            visited[cur.brokenCount][cur.y][cur.x] = cur.weight;
            boolean flag = true;
            for(int i = 0; i < 4; i++) {
                curX = cur.x + dx[i];
                curY = cur.y + dy[i];

                if(!isBoundary(curX, curY)) {
                    continue;
                }

                if(visited[cur.brokenCount][curY][curX] != 0) {
                    continue;
                }

                if(!map[curY][curX]) {
                    q.add(new Node(curX, curY, cur.weight+1, cur.brokenCount+1));
                }


                if(map[curY][curX]) {
                    q.add(new Node(curX, curY, cur.weight+1, cur.brokenCount));
                }
            }
        }
        return -1;
    }

    static boolean isBoundary(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }


    static class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;
        int brokenCount;

        Node(int x, int y, int w, int bc) {
            this.x = x;
            this.y = y;
            weight = w;
            brokenCount = bc;
        }

        @Override
        public int compareTo(Node o) {
            if(weight != o.weight) {
                return weight - o.weight;
            }
            return brokenCount - o.brokenCount;
        }
    }
}

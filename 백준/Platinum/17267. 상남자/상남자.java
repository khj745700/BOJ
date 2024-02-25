import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int curX, curY;
    static int L, R;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';

                if(arr[i][j] == 2) {
                    curX = j;
                    curY = i;
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(bfs());
    }


    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(curX, curY, L, R));
        int count = 1;
        visited = new boolean[N][M];
        visited[curY][curX] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0; i < 2; i++) {
                for(int j = 1 ; j < N; j++) {
                    int curX = cur.x;
                    int curY = cur.y + j*dy[i];
                    if(!isBoundary(curX, curY)) {
                        break;
                    }
                    if(visited[curY][curX]) {
                        break;
                    }

                    if(arr[curY][curX] != 0) {
                        break;
                    }

                    if(arr[curY][curX] == 0) {
                        q.add(new Node(curX, curY, cur.l, cur.r));
                        count++;
                        visited[curY][curX] = true;
                    }
                }
            }

            if(isBoundary(cur.x - 1, cur.y) && cur.l != 0) {
                if(!visited[cur.y][cur.x - 1] && arr[cur.y][cur.x - 1] == 0) {
                    q.add(new Node(cur.x-1, cur.y , cur.l - 1, cur.r));
                    visited[cur.y][cur.x - 1] = true;
                    count++;
                }
            }

            if(isBoundary(cur.x + 1, cur.y) && cur.r != 0) {
                if(!visited[cur.y][cur.x + 1] && arr[cur.y][cur.x + 1] == 0) {
                    q.add(new Node(cur.x+1, cur.y , cur.l, cur.r - 1));
                    visited[cur.y][cur.x + 1] = true;
                    count++;
                }
            }

        }
        return count;
    }

    static boolean isBoundary(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }

    static class Node {
        int x;
        int y;
        int l;
        int r;
        Node(int a, int b, int c, int d) {
            x = a;
            y = b;
            l = c;
            r = d;
        }
    }
}
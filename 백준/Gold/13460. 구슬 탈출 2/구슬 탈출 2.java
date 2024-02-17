import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    static int N, M;

    static PairBall start;
    static int endX;
    static int endY;
    static boolean[][][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        start = new PairBall();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'R') {
                    start.rx = j;
                    start.ry = i;
                    map[i][j] = '.';
                }

                if(map[i][j] == 'B') {
                    start.bx = j;
                    start.by = i;
                    map[i][j] = '.';
                }

                if(map[i][j] == 'O') {
                    endX = j;
                    endY = i;
                }
            }
        }

        System.out.println(simulation());
    }

    static int simulation() {
        Queue<PairBall> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()) {
            PairBall cur = q.poll();
            if(visited[cur.ry][cur.rx][cur.by][cur.bx]) {
                continue;
            }
            if(cur.d == -1) {
                continue;
            }
            if(cur.bx == endX && cur.by == endY) {
                continue;
            }
            if(cur.rx == endX && cur.ry == endY) {
                return cur.d;
            }
            if(cur.d == 11) {
                break;
            }
            visited[cur.ry][cur.rx][cur.by][cur.bx] = true;
            q.add(goLeft(cur));
            q.add(goRight(cur));
            q.add(goDown(cur));
            q.add(goUp(cur));
        }

        return -1;
    }

    static PairBall goLeft(PairBall pb) {
        //블루의 가야 할 곳 찾기.
        int blueX = pb.bx;
        int blueY = pb.by;
        for(int i = 0; i < M; i++) {
            if(map[blueY][blueX] == 'O') {
                break;
            }
            if(map[blueY][blueX-1] == '#') {
                break;
            }

            --blueX;
        }

        //레드의 가야할 곳 찾기.
        int redX = pb.rx;
        int redY = pb.ry;
        for(int i = 0; i < M; i++) {
            if(map[redY][redX] == 'O') {
                break;
            }
            if(map[redY][redX-1] == '#') {
                break;
            }

            --redX;
        }

        if(redX != blueX || redY != blueY) {

            return new PairBall(redX, redY, blueX, blueY, pb.d+1);
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1);
            }
            if(pb.rx > pb.bx) {
                return new PairBall(redX+1, redY, blueX, blueY, pb.d + 1);
            }
            return new PairBall(redX, redY, blueX + 1, blueY, pb.d + 1);
        }
    }

    static PairBall goRight(PairBall pb) {
        //블루의 가야 할 곳 찾기.
        int blueX = pb.bx;
        int blueY = pb.by;
        for(int i = 0; i < M; i++) {
            if(map[blueY][blueX] == 'O') {
                break;
            }
            if(map[blueY][blueX + 1] == '#') {
                break;
            }
            ++blueX;
        }

        //레드의 가야할 곳 찾기.
        int redX = pb.rx;
        int redY = pb.ry;
        for(int i = 0; i < M; i++) {
            if(map[redY][redX] == 'O') {
                break;
            }
            if(map[redY][redX+1] == '#') {
                break;
            }
            ++redX;
        }

        if(redX != blueX || redY != blueY) {
            return new PairBall(redX, redY, blueX, blueY, pb.d+1);
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1);
            }
            if(pb.rx < pb.bx) {
                return new PairBall(redX-1, redY, blueX, blueY, pb.d + 1);
            }

            return new PairBall(redX, redY, blueX - 1, blueY, pb.d + 1);
        }
    }

    static PairBall goUp(PairBall pb) {
        //블루의 가야 할 곳 찾기.
        int blueX = pb.bx;
        int blueY = pb.by;
        for(int i = 0; i < N; i++) {
            if(map[blueY][blueX] == 'O') {
                break;
            }
            if(map[blueY-1][blueX] == '#') {
                break;
            }


            --blueY;
        }

        //레드의 가야할 곳 찾기.
        int redX = pb.rx;
        int redY = pb.ry;
        for(int i = 0; i < N; i++) {
            if(map[redY][redX] == 'O') {
                break;
            }
            if(map[redY-1][redX] == '#') {
                break;
            }

            --redY;
        }

        if(redX != blueX || redY != blueY) {
            return new PairBall(redX, redY, blueX, blueY, pb.d+1);
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1);
            }
            if(pb.ry < pb.by) {
                return new PairBall(redX, redY, blueX, blueY+1, pb.d + 1);
            }
            return new PairBall(redX, redY+1, blueX, blueY, pb.d + 1);
        }
    }

    static PairBall goDown(PairBall pb) {
        //블루의 가야 할 곳 찾기.
        int blueX = pb.bx;
        int blueY = pb.by;
        for(int i = 0; i < N; i++) {
            if(map[blueY][blueX] == 'O') {
                break;
            }
            if(map[blueY+1][blueX] == '#') {
                break;
            }
            ++blueY;
        }

        //레드의 가야할 곳 찾기.
        int redX = pb.rx;
        int redY = pb.ry;
        for(int i = 0; i < N; i++) {
            if(map[redY][redX] == 'O') {
                break;
            }
            if(map[redY+1][redX] == '#') {
                break;
            }

            ++redY;
        }

        if(redX != blueX || redY != blueY) {
            return new PairBall(redX, redY, blueX, blueY, pb.d+1);
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1);
            }
            if(pb.ry < pb.by) {
                return new PairBall(redX, redY-1, blueX, blueY, pb.d + 1);
            }
            return new PairBall(redX, redY, blueX, blueY - 1, pb.d + 1);
        }
    }

    static class PairBall {
        int rx;
        int ry;
        int bx;
        int by;
        int d;

        PairBall(int a, int b, int c, int d, int v) {
            rx = a; ry = b; bx = c ; by = d; this.d = v;
        }
        PairBall() {

        }
    }
}
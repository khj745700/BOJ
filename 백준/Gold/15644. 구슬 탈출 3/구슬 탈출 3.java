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
        PairBall ans = simulation();
        System.out.println(ans == null ? -1 : ans);
    }

    static PairBall simulation() {
        Queue<PairBall> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()) {
            PairBall cur = q.poll();
            if(visited[cur.by][cur.bx][cur.ry][cur.rx]) {
                continue;
            }
            if(cur.bx == endX && cur.by == endY) {
                continue;
            }

            if(cur.d == -1) {
                continue;
            }

            if(cur.rx == endX && cur.ry == endY) {
                return cur;
            }

            if(cur.d == 11) {
                break;
            }
            visited[cur.by][cur.bx][cur.ry][cur.rx] = true;

            q.add(goLeft(cur));
            q.add(goRight(cur));
            q.add(goDown(cur));
            q.add(goUp(cur));
        }

        return null;
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

            return new PairBall(redX, redY, blueX, blueY, pb.d+1, pb.list, 'L');
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1, pb.list, 'L');
            }
            if(pb.rx > pb.bx) {
                return new PairBall(redX+1, redY, blueX, blueY, pb.d + 1, pb.list, 'L');
            }
            return new PairBall(redX, redY, blueX + 1, blueY, pb.d + 1, pb.list, 'L');
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
            return new PairBall(redX, redY, blueX, blueY, pb.d+1, pb.list, 'R');
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1, pb.list, 'L');
            }
            if(pb.rx < pb.bx) {
                return new PairBall(redX-1, redY, blueX, blueY, pb.d + 1, pb.list, 'R');
            }

            return new PairBall(redX, redY, blueX - 1, blueY, pb.d + 1, pb.list, 'R');
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
            return new PairBall(redX, redY, blueX, blueY, pb.d+1, pb.list, 'U');
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1, pb.list, 'L');
            }
            if(pb.ry < pb.by) {
                return new PairBall(redX, redY, blueX, blueY+1, pb.d + 1, pb.list, 'U');
            }
            return new PairBall(redX, redY+1, blueX, blueY, pb.d + 1, pb.list, 'U');
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
            return new PairBall(redX, redY, blueX, blueY, pb.d+1, pb.list, 'D');
        }else {
            if(blueX == endX && blueY == endY) {
                return new PairBall(redX, redY, blueX, blueY, -1, pb.list, 'L');
            }
            if(pb.ry < pb.by) {
                return new PairBall(redX, redY-1, blueX, blueY, pb.d + 1, pb.list, 'D');
            }
            return new PairBall(redX, redY, blueX, blueY - 1, pb.d + 1, pb.list, 'D');
        }
    }

    static class PairBall {
        int rx;
        int ry;
        int bx;
        int by;
        int d;
        List<Character> list;
        PairBall(int a, int b, int c, int d, int v, List<Character> val, char k) {
            rx = a; ry = b; bx = c ; by = d; this.d = v;
            list = new ArrayList<>(val);
            list.add(k);
        }

        PairBall() {
            list = new ArrayList<>();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(char c : list) {
                sb.append(c);
            }
            return d + "\n" + sb;
        }
    }
}
import javax.swing.event.ListDataEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Fish[][] map;
    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int sum = 0;
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new Fish[4][4];
        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())-1;
                map[i][j] = new Fish(num, d, j,i);
                map[i][j].isDead = false;
            }
        }
        sum += map[0][0].num;
        map[0][0].isDead = true;
        backtracking(0, 0, map[0][0].d, map);
        System.out.println(MAX);
    }

    static void backtracking(int x, int y, int d, Fish[][] map) {
        MAX = Math.max(sum, MAX);

        Fish[][] temp = moveMap(map, x, y);

        for(int i = 1; i < 4; i++) {
            int curX = x+dx[d]*i;
            int curY = y+dy[d]*i;

            if(!isBoundary(curX, curY)) {
                break;
            }

            if(temp[curY][curX].isDead) {
                continue;
            }
            Fish cur = temp[curY][curX];
            sum += cur.num;
            cur.isDead = true;
            backtracking(curX, curY, cur.d, temp);
            sum -= cur.num;
            cur.isDead = false;
        }
    }

    static Fish[][] moveMap(Fish[][] map, int sharkX, int sharkY) {
        Fish[][] temp = new Fish[4][4];
        List<Fish> arr = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            for(int j = 0 ; j < 4; j++) {
                temp[i][j] = new Fish(map[i][j]);
                if(!temp[i][j].isDead)
                    arr.add(temp[i][j]);
            }
        }

        arr.sort(null);
        for(Fish cur : arr) {
            for(int i = 0 ; i < 8; i++) {
                int d = (cur.d + i) % 8;
                int curX = cur.x + dx[d];
                int curY = cur.y + dy[d];

                if(!isBoundary(curX, curY)) {
                    continue;
                }

                if(curX == sharkX && curY == sharkY) {
                    continue;
                }

                Fish target = temp[curY][curX];
                //현재위치에 타겟을 옮김.
                temp[cur.y][cur.x] = target;

                //타겟과 위치만 바뀌기때문에 저장함.
                target.x = cur.x;
                target.y = cur.y;

                //갈 곳에 나를 옮김 헤헤
                temp[curY][curX] = cur;

                //헤헤헤
                cur.x = curX;
                cur.y = curY;

                //헤헤 바뀐 위상 저장
                cur.d = d;
                break;
            }
        }

        return temp;
    }
    static boolean isBoundary(int x, int y) {
        return 0 <= x && x < 4 && 0 <= y && y < 4;
    }


    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int num;
        int d;
        boolean isDead;
        Fish(int a, int b, int c, int d) {
            num = a; this.d = b; x= c; y = d;
        }

        Fish(Fish f) {
            x = f.x; y = f.y; num = f.num; d = f.d; isDead = f.isDead;
        }

        public int compareTo(Fish f) {
            return num - f.num;
        }

        public boolean equals(Object o) {
            Fish f = (Fish) o;
            return num == f.num;
        }

        public String toString() {
            return num + " " + operator(d) + " " + y + " " + x;
        }
    }

    public static char operator(int d) {
        char[] oper = {'↑', '↖', '↖', '↙', '↓', '↘', '→', '↗'};
        return oper[d];
    }

}
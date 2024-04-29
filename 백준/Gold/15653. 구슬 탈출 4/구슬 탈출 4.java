import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Node Blue;
    static Node Red;
    static Node Goal;
    static int blueCount = 1;
    static int redCount = 1;
    static int ans = Integer.MAX_VALUE;
    static List<Character> ansList = new ArrayList<>();
    static List<Character> currentList = new ArrayList<>();
    static int[][][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new int[n][m][n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 0; k < n; k++) {
                    Arrays.fill(visited[i][j][k], Integer.MAX_VALUE);
                }
            }
        }
        map = new char[n][m];

        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();

            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'R') {
                    Red = new Node(i, j);
                } else if (map[i][j] == 'B') {
                    Blue = new Node(i, j);
                } else if (map[i][j] == 'O') {
                    Goal = new Node(i, j);
                }

            }
        }
        int[] answer = {Integer.MAX_VALUE};
        dfs(0, -1, answer);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);


    }

    static void dfs(int dept, int prevDire, int[] answer) {
        if (answer[0] <= dept) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (((i + 2) % 4) != prevDire && i != prevDire && canMove(i, dept, answer)) {

//                if(count == 14) System.exit(0);
//                count++;
//                System.out.println("---------------------------------");
//                System.out.println("i = " + i + " dept = " + dept);
//                System.out.println("======== before ============");
//                print();
                int currentBlueMove = blueCount;
                int currentRedMove = redCount;
                if(!move(i, currentBlueMove, currentRedMove, dept)) {
                    continue;
                }
//                System.out.println(" ========== after ============");
//                print();
                dfs(dept + 1, i, answer);
                currentList.remove(currentList.size() - 1);
                rollback(i, currentBlueMove, currentRedMove);
            }

        }

    }

    static boolean move(int dire, int blueMove, int redMove, int depth) {
        int newBX = Blue.x;
        int newBY = Blue.y;
        int newRX = Red.x;
        int newRY = Red.y;

        newBX += dx[dire] * blueMove;
        newBY += dy[dire] * blueMove;


        newRX += dx[dire] * redMove;
        newRY += dy[dire] * redMove;

        if (visited[newRX][newRY][newBX][newBY] < depth) {
            return false;
        }

        visited[newRX][newRY][newBX][newBY] = depth;

        map[Blue.x][Blue.y] = '.';
        map[newBX][newBY] = 'B';
        Blue.x = newBX;
        Blue.y = newBY;
        map[Red.x][Red.y] = '.';
        map[newRX][newRY] = 'R';
        Red.x = newRX;
        Red.y = newRY;
        return true;
    }

    static void rollback(int dire, int blueMove, int redMove) {
        //반대 방향
        dire = (dire + 2) % 4;

        int newBX = Blue.x;
        int newBY = Blue.y;
        int newRX = Red.x;
        int newRY = Red.y;


        newBX += dx[dire] * blueMove;
        newBY += dy[dire] * blueMove;


        newRX += dx[dire] * redMove;
        newRY += dy[dire] * redMove;

        map[Blue.x][Blue.y] = '.';
        map[Red.x][Red.y] = '.';
        map[newBX][newBY] = 'B';
        map[newRX][newRY] = 'R';
        Blue.x = newBX;
        Blue.y = newBY;
        Red.x = newRX;
        Red.y = newRY;

    }

    static boolean canMove(int dire, int dept, int[] answer) {
        //파랑이 구슬 움직일 수 있는지
        blueCount = 1;
        boolean isRed = false;
//        boolean isBlueGoal = false;
        int x = Blue.x;
        int y = Blue.y;

        while (true) {

            int newX = x + (dx[dire] * blueCount);
            int newY = y + (dy[dire] * blueCount);

            if (map[newX][newY] == '#') {
                break;
            } else if (map[newX][newY] == 'R') {
                isRed = true;
            } else if (map[newX][newY] == 'O') {
//                if(isRed) return false;
//
//                isBlueGoal = true;
//                break;

                return false;
            }

            blueCount++;
        }

        redCount = 1;
        boolean isBlue = false;
        boolean isRedGoal = false;
        x = Red.x;
        y = Red.y;

        while (true) {

            int newX = x + (dx[dire] * redCount);
            int newY = y + (dy[dire] * redCount);

            if (map[newX][newY] == '#') {
                break;
            } else if (map[newX][newY] == 'B') {
                isBlue = true;
            } else if (map[newX][newY] == 'O') {
                if (isBlue) return false;

                isRedGoal = true;
                break;
            }
            redCount++;

        }

        if (isRedGoal) {
//            System.out.println(count);

            if (dept + 1 < ans) {
                ansList = new ArrayList<>();

                for (char element : currentList) {
                    ansList.add(element);
                }

                if (dire == 0) {
                    ansList.add('U');
                } else if (dire == 1) {
                    ansList.add('R');
                } else if (dire == 2) {
                    ansList.add('D');
                } else if (dire == 3) {
                    ansList.add('L');
                }
            }


            ans = Math.min(ans, dept + 1);
            answer[0] = ans;

//            System.exit(0);
        }

        //파란색이 안움직인 경우 + 빨간색이 안움직인 경우 -> return false;
        if (blueCount == 1 && redCount == 1) return false;
        if ((blueCount == 2 && isRed) && (redCount == 2 && isBlue)) return false;

        if (dire == 0) {
            currentList.add('U');
        } else if (dire == 1) {
            currentList.add('R');
        } else if (dire == 2) {
            currentList.add('D');
        } else if (dire == 3) {
            currentList.add('L');
        }

        blueCount = isRed ? blueCount - 1 : blueCount;
        redCount = isBlue ? redCount - 1 : redCount;
        blueCount--;
        redCount--;
        return true;

    }


    static void print() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

}

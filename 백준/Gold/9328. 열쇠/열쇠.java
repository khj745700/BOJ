import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int H, W;
    static char[][] arr;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static HashSet<Character> key;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        while(test_case --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            key = new HashSet<>();
            arr = new char[H][];
            for(int i = 0 ; i < H; i++) {
                String input = br.readLine();
                arr[i] = input.toCharArray();
            }

            String keys = br.readLine();
            if(keys.length() != 1 || keys.charAt(0) != '0') {
                for(int i = 0 ; i < keys.length(); i++) {
                    key.add(Character.toUpperCase(keys.charAt(i)));
                }
            }

            sb.append(bfs());
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> findKey = new ArrayList<>();

        int count = 0;
        for(int i = 0; i < H; i++) {
            if(arr[i][0] == '.') {
                q.add(new int[]{0, i});
            }
            if(arr[i][W-1] == '.') {
                q.add(new int[]{W-1, i});
            }

            if(arr[i][0] == '$') {
                q.add(new int[]{0, i});
                count++;
                arr[i][0] = '.';
            }
            if(arr[i][W-1] == '$') {
                q.add(new int[]{W-1, i});
                count++;
                arr[i][W-1] = '.';
            }

            if(Character.isAlphabetic(arr[i][0])) {
                if(Character.isUpperCase(arr[i][0])) {
                    findKey.add(new int[]{0,i});
                }else {
                    key.add(Character.toUpperCase(arr[i][0]));
                    q.add(new int[]{0,i});
                    arr[i][0] = '.';
                }
            }

            if(Character.isAlphabetic(arr[i][W-1])) {
                if(Character.isUpperCase(arr[i][W-1])) {
                    findKey.add(new int[]{W-1,i});
                }else {
                    key.add(Character.toUpperCase(arr[i][W-1]));
                    q.add(new int[]{W-1, i});
                    arr[i][W-1] = '.';
                }
            }
        }

        for(int i = 0; i < W; i++) {
            if(arr[0][i] == '.') {
                q.add(new int[]{i, 0});
            }
            if(arr[H-1][i] == '.') {
                q.add(new int[]{i, H-1});
            }

            if(arr[0][i] == '$') {
                q.add(new int[]{i, 0});
                count++;
                arr[0][i] = '.';
            }
            if(arr[H-1][i] == '$') {
                q.add(new int[]{i, H-1});
                count++;
                arr[H-1][i] = '.';
            }

            if(Character.isAlphabetic(arr[0][i])) {
                if(Character.isUpperCase(arr[0][i])) {
                    findKey.add(new int[]{i, 0});
                }else {
                    key.add(Character.toUpperCase(arr[0][i]));
                    arr[0][i] = '.';
                    q.add(new int[]{i,0});
                }
            }
            if(Character.isAlphabetic(arr[H-1][i])) {
                if(Character.isUpperCase(arr[H-1][i])) {
                    findKey.add(new int[]{i, H-1});
                }else {
                    key.add(Character.toUpperCase(arr[H-1][i]));
                    arr[H-1][i] = '.';
                    q.add(new int[]{i, H-1});
                }
            }
        }
        boolean[][] visited = new boolean[H][W];

        if(q.isEmpty()) {
            for(int i = findKey.size() - 1 ; i >= 0 ; i--) {
                int[] cursor = findKey.get(i);
                if(key.contains(arr[cursor[1]][cursor[0]])) {
                    q.add(cursor);
                    arr[cursor[1]][cursor[0]] = '.';
                    findKey.remove(i);
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0 ; i < 4; i++) {
                int curX = cur[0] + dx[i];
                int curY = cur[1] + dy[i];

                if(isNotBoundary(curX, curY)){
                    continue;
                }

                if(visited[curY][curX]) {
                    continue;
                }

                if(arr[curY][curX] == '*') {
                    continue;
                }

                if(arr[curY][curX] == '.') {
                    q.add(new int[]{curX, curY});
                    visited[curY][curX] = true;
                }

                if(arr[curY][curX] =='$') {
                    q.add(new int[]{curX, curY});
                    count++;
                    visited[curY][curX] = true;
                    arr[curY][curX] = '.';
                }

                if(Character.isAlphabetic(arr[curY][curX])) {
                    if(Character.isUpperCase(arr[curY][curX])) {
                        findKey.add(new int[]{curX, curY});
                    }else {     //열쇠 찾기
                        key.add(Character.toUpperCase(arr[curY][curX]));
                        q.add(new int[]{curX, curY});
                        visited[curY][curX] = true;
                        arr[curY][curX] = '.';
                    }
                }
            }

            if(q.isEmpty()) {
                for(int i = findKey.size() - 1 ; i >= 0 ; i--) {
                    int[] cursor = findKey.get(i);
                    if(key.contains(arr[cursor[1]][cursor[0]])) {
                        q.add(cursor);
                        arr[cursor[1]][cursor[0]] = '.';
                        findKey.remove(i);
                    }
                }
            }
        }
        return count;
    }

    static boolean isNotBoundary(int x, int y) {
        return 0 > x ||  W <= x || 0 > y || H <= y;
    }
}

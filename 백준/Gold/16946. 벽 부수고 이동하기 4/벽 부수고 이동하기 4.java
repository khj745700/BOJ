import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;

public class Main {
    static class Point{
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
        int y;
        int x;
        @Override
        public int hashCode() {
            return y*10000+x %1234567;
        }
        @Override
        public boolean equals(Object obj) {
            return this.y == ((Point)obj).y && this.x == ((Point)obj).x;
        }
    }
    static int n;
    static int m;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<int[]> list;
    static HashSet<Point> set;
    static Queue<int[]> queue;
    static StringBuilder sb;

    public static void solution() {
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(matrix[i][j] == 0 && !visited[i][j])
                    bfs(i, j);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++)
                sb.append(matrix[i][j]%10);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void bfs(int i, int j) {
        list.clear();
        set.clear();
        queue.add(new int[] {i, j});
        visited[i][j] = true;
        int cnt=0;
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            list.add(node);
            cnt++;
            for(int k=0; k<4; k++) {
                int y = node[0]+dy[k];
                int x = node[1]+dx[k];
                if(y<0 || y>=n || x<0 || x>=m)
                    continue;
                if(matrix[y][x]==0 && !visited[y][x]) {
                    visited[y][x] = true;
                    queue.add(new int[] {y, x});
                }
            }
        }
        for(int[] cell : list)
            for(int k=0; k<4; k++) {
                int y = cell[0]+dy[k];
                int x = cell[1]+dx[k];
                if(y<0 || y>=n || x<0 || x>=m)
                    continue;
                Point point = new Point(y, x);
                if(matrix[y][x] != 0 && !set.contains(point)) {
                    matrix[y][x] += cnt;
                    set.add(point);
                }
            }
    }

    public static int[] convert(String[] temp) {
        int[] result = new int[temp.length];
        for(int i=0; i<temp.length; i++)
            result[i] = Integer.parseInt(temp[i]);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        n = Integer.parseInt(temp[0]);
        m = Integer.parseInt(temp[1]);
        matrix = new int[n][];
        visited = new boolean[n][m];
        sb = new StringBuilder();
        list = new ArrayList<int[]>();
        queue = new ArrayDeque<int[]>();
        set = new HashSet<>();
        for(int i=0; i<n; i++)
            matrix[i] = convert(br.readLine().split(""));
        solution();
    }
}
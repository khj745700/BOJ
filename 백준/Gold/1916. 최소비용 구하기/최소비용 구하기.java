
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] graph;
    static int[] d;
    static boolean[] visited;

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i = 0 ; i < N; i++) {
            Arrays.fill(graph[i], INF);
        }
        visited = new boolean[N];
        d = new int[N];
        StringTokenizer st;
        while(M --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            graph[x][y] = Math.min(graph[x][y], w);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        if (N >= 0) System.arraycopy(graph[start], 0, d, 0, N);

        visited[start] = true;
        for(int i = 0 ; i < N ; i++) {
            int current = getSmallIndex();
            if(current == -1){
                break;
            }
            visited[current] = true;
            for(int j = 0 ; j < N; j++) {
                if(!visited[j]) {
                    if(d[current] + graph[current][j] < d[j]) {
                        d[j] = d[current] + graph[current][j];
                    }
                }
            }
        }

        System.out.println(d[end]);
    }


    static int getSmallIndex() {
        int min = INF;
        int idx = -1;
        for(int i = 0 ; i < N; i++) {
            if(d[i] < min && !visited[i]){
                min = d[i];
                idx = i;
            }
        }
        return idx;
    }
}

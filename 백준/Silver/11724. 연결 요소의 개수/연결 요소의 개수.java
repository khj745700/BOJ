import java.io.*;
import java.util.*;
public class Main{
    static int N, M;
    static int[][] graph;
    static int count;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visit = new boolean[N];
        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u, v;
            u = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken()) - 1;
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        int startNode;

        while((startNode = findFirstIndex()) != -1) {
            dfs(startNode);
            count++;
        }
        for(int i =0 ; i < visit.length; i++) {
            if(!visit[i]){
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            visit[node] = true;
            for(int i = 0; i < N; i++) {
                if(graph[node][i] == 1 && !visit[i]) {
                    stack.push(i);
                }
            }
        }
    }

    static int findFirstIndex() {
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(graph[i][j] == 1 && !visit[i]) {
                    return i;
                }
            }
        }
        return -1;
    }
}

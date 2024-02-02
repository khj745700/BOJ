import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new List[N+1];
        visited = new int[N+1];
        for(int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        visited[1] = 1;
        buildTrees(1);
        for(int i = 2; i <= N; i++) {
            sb.append(visited[i]);
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    static void buildTrees(int start) {
        for(Integer v : arr[start]) {
            if(visited[v] > 0) {
                continue;
            }
            visited[v] = start;
           buildTrees(v);
        }
    }

}
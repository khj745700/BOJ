import java.io.*;
import java.util.*;
public class Main{
    static int T, N;
    static int[] graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T --> 0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            graph = new int[N];
            visit = new boolean[N];
            for(int i = 0; i < N; i++) {
                graph[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            int count = 0;
            for(int i = 0 ; i < N; i++) {
                if(!visit[i]){
                    DFS(i);
                    count++;
                }
            }

            bw.append(String.valueOf(count));
            bw.newLine();
        }
        bw.flush();
    }


    static void DFS(int start) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        set.add(start);
        stack.push(start);

        while(!stack.isEmpty()) {
            int cur = stack.pop();
            visit[cur] = true;
            if(!set.contains(graph[cur])){
                set.add(graph[cur]);
                stack.push(graph[cur]);
            } else {
                return;
            }
        }
    }
}

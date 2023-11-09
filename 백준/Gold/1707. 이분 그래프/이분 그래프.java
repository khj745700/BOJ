import java.io.*;
import java.util.*;
public class Main{
    static int K, V, E;
    static List<List<Integer>> graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] visit;

    static final int NOT_VISIT = 0;
    static final int RED = -1;
    static final int BLACK = 1;
    public static void main(String[] args) throws IOException {

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(K --> 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visit = new int[V];

            setGraph();
            boolean isBiGraph = false;
            for(int i = 0 ; i < V; i++) {
                if(visit[i] == NOT_VISIT){
                    isBiGraph = BFS(i);
                }

                if(!isBiGraph) {
                    break;
                }
            }
            if(isBiGraph) {
                bw.append("YES");
            }else {
                bw.append("NO");
            }
            bw.newLine();
        }
        bw.flush();
    }


    static void setGraph() throws IOException {
        StringTokenizer st;
        graph = new ArrayList<>();
        for (int i = 0 ; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0 ; i < E ; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            graph.get(from).add(to);
            graph.get(to).add(from);

        }
    }

    static boolean BFS(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        visit[start] = RED;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : graph.get(cur)) {
                if(visit[cur] == visit[i]) {
                    return false;
                }

                if(visit[i] == NOT_VISIT){
                    q.add(i);
                    visit[i] = visit[cur] * -1;
                }
            }
        }

        return true;
    }
}

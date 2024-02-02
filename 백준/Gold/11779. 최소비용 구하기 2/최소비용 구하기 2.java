import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Node>[] map;
    static long[] dist;
    static long INF = 100_000_000_000L;
    static int[] pre;

    static int start;
    static int end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new List[N + 1];
        dist = new long[N+1];
        pre = new int[N+1];

        Arrays.fill(dist, INF);

        for(int i = 0 ; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map[u].add(new Node(v, e));  //단방향 이므로...
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijsktra(start);
        System.out.println(dist[end]);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int i = end;
        while(i != start) {
            q.push(i);
            i = pre[i];
        }

        q.push(start);
        System.out.println(q.size());
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(q.pollFirst()).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void dijsktra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        pq.add(new Node(start , 0));
        dist[start] = 0;
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for(Node e : map[cur]) {
                if(dist[e.end] > dist[cur] + e.weight) {
                    dist[e.end] = dist[cur] + e.weight;
                    pre[e.end] = cur;
                    pq.add(new Node(e.end, (int)dist[e.end]));
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int e, int w) {
            end = e;
            weight = w;
        }


        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
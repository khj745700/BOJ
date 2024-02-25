import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int start, end;
    static int[] dist;
    static List<Node>[] map;
    static List<Integer>[] shortestLoad;
    static boolean[][] cantgo;
    static int INF = 1_000_000_000;

    static List<Coor> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new LinkedList<>();
        while (N != 0 || M != 0) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            dist = new int[N];
            map = new List[N];
            shortestLoad = new List[N];
            cantgo = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = new ArrayList<>();
                shortestLoad[i] = new ArrayList<>();
            }


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                map[u].add(new Node(v, p));
            }

            dijsktra();
            removeLoad(end);
            dijsktra();
            sb.append(dist[end] == INF ? -1 : dist[end]);
            sb.append('\n');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);

    }

    static void removeLoad(int start) {
        for(int i : shortestLoad[start]) {
            if(cantgo[i][start]) continue;
            cantgo[i][start] = true;
            removeLoad(i);
        }
    }

    static void dijsktra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        Arrays.fill(dist, INF);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.end;
            if(dist[curNode] < cur.val) continue;

            for (Node next : map[curNode]) {
                if(cantgo[curNode][next.end]) continue;

                if(dist[next.end] == cur.val + next.val) {
                    shortestLoad[next.end].add(curNode);
                }else if (dist[next.end] > cur.val + next.val) {
                    dist[next.end] = cur.val + next.val;
                    shortestLoad[next.end].clear();
                    shortestLoad[next.end].add(curNode);
                    pq.add(new Node(next.end, dist[next.end]));
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        int end;
        int val;

        Node(int a, int b) {
            end = a;
            val = b;
        }

        @Override
        public boolean equals(Object o) {
            Node cur = (Node) o;
            return this.end == cur.end;
        }

        public int compareTo(Node e) {
            return val - e.val;
        }
    }

    static class Coor {
        int start;
        int end;

        Coor(int a, int b) {
            start = a;
            end = b;
        }

        public boolean equals(Object o) {
            Coor c = (Coor) o;
            return this.start == c.start && this.end == c.end;
        }

        public int hashCode() {
            return (start * 10000 + end) % 1234567;
        }
    }
}
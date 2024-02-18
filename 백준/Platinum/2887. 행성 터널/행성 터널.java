import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] set;
    static int[][] planets;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int sum;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        set = new int[N];
        planets = new int[N][4];
        for(int i = 0 ; i < N; i++) {
            set[i] = i;
        }

        for(int i =0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i][0] = x;
            planets[i][1] = y;
            planets[i][2] = z;
            planets[i][3] = i;
        }

        Arrays.sort(planets, Comparator.comparingInt(i -> i[0]));
        for(int i = 0; i < N-1; i++) {
            pq.add(new Node(planets[i][3], planets[i+1][3], Math.abs(planets[i+1][0] - planets[i][0])));
        }

        Arrays.sort(planets, Comparator.comparingInt(i -> i[1]));
        for(int i = 0; i < N-1; i++) {
            pq.add(new Node(planets[i][3], planets[i+1][3], Math.abs(planets[i+1][1] - planets[i][1])));
        }

        Arrays.sort(planets, Comparator.comparingInt(i -> i[2]));
        for(int i = 0; i < N-1; i++) {
            pq.add(new Node(planets[i][3], planets[i+1][3], Math.abs(planets[i+1][2] - planets[i][2])));
        }

        count = 1;
        while(count != N) {
            Node cur = pq.poll();
            if(union(cur)) {
                count++;
            }
        }
        System.out.println(sum);
    }

    static int unionFind(int v) {
        if(set[v] == v) {
            return v;
        }
        return set[v] = unionFind(set[v]);
    }

    static boolean union(Node v) {
        int a = unionFind(v.v);
        int b = unionFind(v.u);

        if(a == b) {
            return false;
        }
        set[a] = b;
        sum+=v.d;
        return true;
    }

    static class Node implements Comparable<Node> {
        int u;
        int v;
        int d;
        Node(int a, int b, int c) {
            u = a; v = b; d = c;
        }


        @Override
        public int compareTo(Node o) {
            return d - o.d;
        }
    }
}
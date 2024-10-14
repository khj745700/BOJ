import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] isMale;
    static PriorityQueue<Node> nodes;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new PriorityQueue<>();
        isMale = new boolean[N + 1];
        weight = new int[N + 1];

        for(int i = 0 ; i <=N; i++) {
            weight[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            String sx = st.nextToken();
            switch(sx) {
                case "M":
                    isMale[i] = true;
                    break;
                case "W":
                    isMale[i] = false;
                    break;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(isMale[start] ^ isMale[end]) {
                nodes.add(new Node(start, end, weight));
            }
        }

        int val = spanningTree();
        System.out.println(val);
    }

    static int spanningTree() {
        int sum = 0;
        int count = 0;
        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            if(merge(node) ) {
                count++;
                sum+=node.weight;
            }
        }

        if(count == N - 1) {
            return sum;
        }else {
            return -1;
        }
    }

    static boolean merge(Node node) {
        int u = getRoot(node.u);
        int v = getRoot(node.v);
        if(u != v) {
            weight[u] = weight[v];
            return true;
        }
        return false;
    }


    static int getRoot(int u) {
        if(weight[u] == u) {
            return u;
        }
        weight[u] = getRoot(weight[u]);
        return weight[u];
    }



    static class Node implements Comparable<Node> {
        int u, v;
        int weight;

        Node(int start, int end, int weight) {
            u = start;
            v = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }
}
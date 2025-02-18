import java.io.*;

import java.util.*;

public class Main {
    static Node[] arr;
    static int N;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static String solution() {
        int[] priorities = new int[N];
        setPriority(arr, priorities);

        StringBuilder sb = new StringBuilder();
        for(int priority : priorities) {
            sb.append(priority);
            sb.append(' ');
        }

        return sb.toString();
    }

    static void setPriority(Node[] arr, int[] priority) {
        int i = 0;
        int before = pq.peek().val;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(before != node.val) {
                i++;
                before = node.val;
            }
            priority[node.idx] = i;
        }
    }

    static void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
            pq.add(arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input(br);
        System.out.println(solution());
    }

    static class Node implements Comparable<Node> {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return this.val - o.val;
        }
    }
}
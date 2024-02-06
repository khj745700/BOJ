import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long list[], tree[];
    static int N, M, K;
 
    static long init(int node, int s, int e) {
        if (s == e)
            return tree[node] = list[s];
 
        int m = (s + e) / 2;
        return tree[node] = init(node * 2, s, m) + init(node * 2 + 1, m + 1, e);
    }
 
    static void update(int node, int s, int e, int idx, long diff) {
        if (idx < s || idx > e)
            return;
 
        tree[node] += diff;
 
        int m = (s + e) / 2;
        if (s != e) {
            update(node * 2, s, m, idx, diff);
            update(node * 2 + 1, m + 1, e, idx, diff);
        }
    }
 
    static long query(int node, int s, int e, int l, int r) {
        if (l <= s && e <= r)
            return tree[node];
        if (s > r || l > e)
            return 0;
 
        int m = (s + e) / 2;
 
        return query(node * 2, s, m, l, r) + query(node * 2 + 1, m + 1, e, l, r);
    }
 
    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new long[N + 1];
        tree = new long[N * 4 + 1];
 
        for (int i = 1; i <= N; i++) {
            list[i] = Long.parseLong(br.readLine());
        }
 
        init(1, 1, N);
 
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
 
            if (a == 1) {
                update(1, 1, N, b, c - list[b]);
                list[b] = c;
            } else {
                sb.append(query(1, 1, N, b, (int) c) + "\n");
            }
        }
 
        System.out.println(sb.toString());
    }
 
    public static void main(String[] args) throws Exception {
        input();
    }
}

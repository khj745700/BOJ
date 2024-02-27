import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static double[][] arr;
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new double[N][2];
        set = new int[N];
        for(int i = 0; i < N; i++) {
            set[i] = i;
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        List<Edge> edgeList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 1; j < N; j++) {
                edgeList.add(new Edge(i, j, getInstance(arr[i], arr[j])));
            }
        }

        edgeList.sort(null);

        int count = 0;
        double ans = 0;
        for (Edge cur : edgeList) {
            if(union(cur.p1, cur.p2)) {
                ans += cur.d;
                count++;
            }

            if(count == N - 1) {
                break;
            }
        }
        System.out.printf("%.2f", ans);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) {
            return false;
        }
        set[a] = b;
        return true;
    }

    static int find(int a) {
        if(set[a] == a) {
            return a;
        }
        return set[a] = find(set[a]);
    }

    static double getInstance(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    static class Edge implements Comparable<Edge> {
        int p1;
        int p2;
        double d;

        Edge(int a, int b, double c) {
            p1 = a; p2 = b; d = c;
        }

        public int compareTo(Edge p) {
            return (int)((d - p.d) * 10);
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static Map<String, Node> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            set = new HashMap<>();
            int n  = Integer.parseInt(br.readLine());
            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();
                set.putIfAbsent(first, new Node(first));
                set.putIfAbsent(second, new Node(second));
                union(first, second);
                sb.append(find(first).degree);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }


    static Node find(String val) {
        Node cur = set.get(val);
        if(val.equals(cur.root)) {
            return cur;
        }
        cur = find(cur.root);
        set.put(val, cur);
        return cur;
    }

    static boolean union(String f1, String f2) {
        Node a1 = find(f1);
        Node a2 = find(f2);

        if(a1.root.equals(a2.root)){
            return false;
        }

        if(a1.degree >= a2.degree ) {
            set.replace(a2.root, a1);
            a1.degree+= a2.degree;
        }else {
            set.replace(a1.root, a2);
            a2.degree += a1.degree;
        }

        return true;
    }

    static class Node {
        private String root;
        private int degree;

        Node(String r) {
            root = r;
            degree = 1;
        }
    }
}

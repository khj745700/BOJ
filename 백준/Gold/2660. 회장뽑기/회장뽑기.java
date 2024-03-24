import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new List[N+1];

        for(int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while(a != -1 || b != -1) {
            map[a].add(b);
            map[b].add(a);

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }
        List<Integer>[] bucket = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            bucket[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++ ) {
            int val = getVal(i);
            bucket[val].add(i);
        }

        for(int i = 1; i <= N; i++) {
            if(bucket[i].size() != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(i).append(' ').append(bucket[i].size());
                sb.append('\n');
                for(int v : bucket[i]){
                    sb.append(v).append(' ');
                }
                System.out.println(sb);
                break;
            }
        }
    }


    static int getVal(int s) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        boolean[] visited = new boolean[N+1];
        visited[s] = true;

        int size = q.size();
        int count = 0;
        while(size --> 0) {

            for(int i : map[q.poll()]) {
                if(!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }

            if(size == 0 && !q.isEmpty()) {
                size = q.size();
                count++;
            }
        }

        return count;
    }
}


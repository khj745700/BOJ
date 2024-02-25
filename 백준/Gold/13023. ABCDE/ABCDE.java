import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new List[N];
        for(int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }


        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        boolean flag = false;
        boolean[] visited = new boolean[N];
        for(int i = 0 ; i < N; i++) {
            visited[i] = true;
            if(flag = backTracking(i, 0, visited)) {
                break;
            }
            visited[i] = false;
        }

        System.out.println(flag ? 1 : 0);
    }


    static boolean backTracking(int start, int cnt, boolean[] visited) {
        if(cnt == 4) {
            return true;
        }

        for(int i : list[start]) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            if(backTracking(i, cnt+1, visited)) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }
}
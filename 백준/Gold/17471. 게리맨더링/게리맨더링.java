import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] map;
    static int[] population;
    static boolean[] check;
    static int MIN = Integer.MAX_VALUE;
    static int total = 0;
    static final boolean RED = true;
    static final boolean BLUE = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new List[N+1];
        population = new int[N+1];

        for(int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            total+= population[i];
        }

        check = new boolean[N+1];
        for(int i = 1 ; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            while(size --> 0) {
                int v = Integer.parseInt(st.nextToken());
                map[i].add(v);
            }
        }
        permutation(1);
        System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
    }
    static void permutation(int depth) {
        if(depth <= N) {
            if(isAllConnection(getStartIdx(RED), RED) && isAllConnection(getStartIdx(BLUE), BLUE)){
                int redPopulation = getPopularSum(RED);
                int bluePopulation = total - redPopulation;
                MIN = Math.min(Math.abs(redPopulation - bluePopulation), MIN);
            }
        }

        for(int i = depth; i <= N; i++) {
            if(check[i] == RED) {
                continue;
            }
            check[i] = RED;
            permutation(i+1);
            check[i] = BLUE;
        }
    }

    static boolean connectionCheck(int u, int v, boolean flag) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(u);
        boolean[] visited = new boolean[N+1];
        while(!q.isEmpty()) {

            int cur = q.poll();
            if(visited[cur]) {
                continue;
            }

            if(cur == v) {
                return true;
            }
            visited[cur] = true;
            for(int vortex : map[cur]) {
                if(!visited[vortex] && check[vortex] == flag){
                    q.add(vortex);
                }
            }
        }
        return false;
    }


    static int getStartIdx(boolean flag) {
        for(int i = 1; i <= N; i++) {
            if(check[i] == flag) {
                return i;
            }
        }
        return 0;
    }

    static boolean isAllConnection(int start, boolean flag) {
        for(int j = 1; j <= N; j++ ) {
            if (check[j] != flag) {
                continue;
            }

            if (!connectionCheck(start, j, flag)) {
                return false;
            }
        }
        return true;
    }

    static int getPopularSum(boolean flag) {
        int ans = 0;
        for(int i = 1; i <= N; i++) {
            if(check[i] == flag) {
                ans+= population[i];
            }
        }
        return ans;
    }
}
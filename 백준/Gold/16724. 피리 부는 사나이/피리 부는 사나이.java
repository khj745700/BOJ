import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] set;
    static int N, M;

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        set = new int[N * M];
        arr = new char[N][];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < set.length; i++) {
            set[i] = i;
        }
        for(int i = 0; i < N * M; i++) {
            dfs(i);
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0 ; i < N * M ; i++) {
            hashSet.add(find(set[i]));
        }
        System.out.println(hashSet.size());
    }

    static void dfs(int val) {
        int find = 0;
        switch (arr[val / M][val % M]){
            case 'D':
                find = find(val + M);
                if(unionFind(find, val)) {
                    dfs(val);
                }
                break;
            case 'R':
                find = find(val + 1);
                if(unionFind(find, val)) {
                    dfs(val);
                }
                break;
            case 'L':
                find = find(val - 1);
                if(unionFind(find, val)) {
                    dfs(val);
                }
                break;
            case 'U':
                find = find(val - M);
                if(unionFind(find, val)) {
                    dfs(val);
                }
                break;
        }
    }



    static int find(int v) {
        if(set[v] == v) {
            return v;
        }
        return set[v] = find(set[v]);
    }

    static boolean unionFind(int u, int v) {
        u = find(u);
        v = find(v);
        if(u == v) {
            return false;
        }
        set[u] = v;
        return true;
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] W;
    static int[] V;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N + 1];
        V = new int[K + 1];
        dp = new Integer[N+1][K+1];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N, K));
    }


    static int knapsack(int i, int k) {
        if(i < 0) {
            return 0;
        }

        if(dp[i][k] == null) {
            //만약 담을 수 없는 경우의 수
            if(W[i] > k) {
                dp[i][k] = knapsack(i-1,k);
            }
            //만약 담을 수 있는 경우의 수
            if(W[i] <= k) {
                dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k-W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }

}
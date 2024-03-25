import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int C, N;
    static int[] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int max = 0;
        dp = new int[C+101];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            for(int j = person ; j < C + 101; j++) {
                dp[j] = Math.min(dp[j], dp[j-person] + coin);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = C; i < C+101; i++ ) {
            answer = Math.min(answer, dp[i]);

        }

        System.out.println(answer);
    }


}


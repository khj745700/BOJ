import java.io.*;
import java.util.*;

public class Main {
    static long[] dp;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        list = new int[T];
        for(int i = 0; i < T; i++) {
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(list[i], max);
        }

        dp = new long[max + 4];
        dp[0] = 0 ;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i < dp.length; i++) {
            dp[i] = (dp[i - 1] % 1_000_000_009 + dp[i - 2] % 1_000_000_009 + dp[i - 3] % 1_000_000_009 ) % 1_000_000_009;
        }

        for(int i = 0; i < T; i++) {
            System.out.println(dp[list[i]]);
        }
    }
}
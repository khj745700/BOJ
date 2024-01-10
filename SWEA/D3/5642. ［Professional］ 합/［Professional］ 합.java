import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] arr;
    static Integer[] dp;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int test_case = 1;
        StringTokenizer st;
        while(T --> 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new Integer[N];
            st = new StringTokenizer(br.readLine());
            
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            max = arr[0];
            dp[0] = arr[0];
            for(int i = 1; i < N; i++) {
                if(dp[i] == null){
                    dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                    max = Math.max(max, dp[i]);
                }
            }

            bw.append("#" + test_case++ +" " + max);
            bw.newLine();
        }
        bw.flush();
    }
}

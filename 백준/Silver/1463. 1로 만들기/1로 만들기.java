import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        if(n >= 2){
            dp[2] = 1;
        }
        if(n>= 3){
            dp[3] = 1;
        }
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-1];
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2]);
            }
            if( i % 3 == 0){
                dp[i] = Math.min(dp[i],dp[i/3]);
            }
            dp[i]+=1;
        }
        bw.append(dp[n]+"");
        bw.flush();
    }
}
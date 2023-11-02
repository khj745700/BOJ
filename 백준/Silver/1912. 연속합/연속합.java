import java.util.*;
import java.io.*;

public class Main{
    static Integer[] dp;
    static int max;
    static int[] seq;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int length = Integer.parseInt(br.readLine());
        dp = new Integer[length];
        seq = new int[length];
        
        args = br.readLine().split(" ");
        for(int i = 0 ; i < length; i++) {
            seq[i] = Integer.parseInt(args[i]);
        }
        dp[0] = seq[0];
        max = seq[0];
        recursive(length - 1);    
        bw.append(String.valueOf(max));
        bw.flush();
    }
    
    private static int recursive(int n) {
         if(dp[n] == null) {
             dp[n] = Math.max(recursive(n-1) + seq[n], seq[n]);
             max = Math.max(max, dp[n]);
         }
        
        return dp[n];
    }
}

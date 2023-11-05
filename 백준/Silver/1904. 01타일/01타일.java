import java.io.*;
import java.util.*;

public class Main{
    static Integer[] dp;
    static int N;
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new Integer[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        recursive(N);
        System.out.println(dp[N]);
    }


    static int recursive(int idx) {
        if(dp[idx] != null){
            return dp[idx];
        }
        return dp[idx] = (recursive(idx - 1) + recursive(idx - 2)) % 15746;
    }
}

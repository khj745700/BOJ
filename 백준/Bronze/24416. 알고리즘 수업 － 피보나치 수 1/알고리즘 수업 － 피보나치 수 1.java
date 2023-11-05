import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static Integer[] dp;
    static int count1 = 0;
    static int count2 = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new Integer[N + 1];

        dp[1] = 1;
        dp[2] = 1;

        fibonacci(N);
        fibonacci2(N);
        System.out.println(count2 + " " + count1);
    }

    static int fibonacci(int n) {

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            count1++;
        }
        return dp[n];
    }

    static int fibonacci2(int n) {
        if(n == 1 || n == 2) {
            return 1;
        }
        count2++;
        return fibonacci2(n - 1) + fibonacci2(n-2);
    }
}

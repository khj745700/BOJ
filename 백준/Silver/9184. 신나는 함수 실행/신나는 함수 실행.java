import java.util.*;
import java.io.*;

public class Main{
    static Integer[][][] dp;
    private static final String FORMAT = "w(%d, %d, %d) = %d";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        while(!(a == -1 && b == -1 && c == -1)) {
            int num = 0;
            if(a <= -1 || b <= -1 || c <= -1) {
                num = 1;
            } else {
                dp = new Integer[21][21][21];
                num = recursive(a,b,c);
            }
            bw.append(String.format(FORMAT, a,b,c,num));
            bw.newLine();

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        bw.flush();
    }


    private static int recursive(int a, int b, int c) {
        if(a<=0 || b<= 0 || c<=0) {
            return 1;
        }
        if(a>20 || b>20 || c>20) {
            return recursive(20, 20, 20);
        }
        if(dp[a][b][c] != null) {
            return dp[a][b][c];
        }
        if(a < b && b < c) {
            return dp[a][b][c] = recursive(a, b, c-1) + recursive(a, b-1, c-1) - recursive(a, b-1, c);
        }
        return dp[a][b][c] = recursive(a-1, b, c) + recursive(a-1, b-1, c) + recursive(a-1, b, c-1) - recursive(a-1, b-1, c-1);
    }
}
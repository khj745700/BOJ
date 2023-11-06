import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static Integer[][] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new Integer[N][2];
        dp = new Integer[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (data, data2) -> data[0] - data2[0]);

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(LIS(i), max);
        }
        System.out.println(N - max);
    }

    private static int LIS(int index) {
        if(dp[index] != null){
            return dp[index];
        }

        dp[index] = 1;
        for(int i = index + 1 ; i < N; i++) {

            if(arr[index][1] < arr[i][1]) {
                dp[index] = Math.max(dp[index], LIS(i) + 1);
            }
        }
        return dp[index];
    }
}

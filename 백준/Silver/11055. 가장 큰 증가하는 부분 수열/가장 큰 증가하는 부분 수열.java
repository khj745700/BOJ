import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] dp = new int[1001];
    static int[] data = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < size; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = data[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < size; i++){
            dp[i] = data[i];
            for(int j = 0 ; j < i; j++){
                if(data[i] > data[j]){
                    dp[i] = Math.max(dp[j] + data[i], dp[i]);
                }
            }
        }
        for(int i = 0; i < size; i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        bw.append(max+"");
        bw.flush();
    }
}

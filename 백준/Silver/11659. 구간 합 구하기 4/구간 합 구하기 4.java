import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] sum;
    static int[] data;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        data = new int[N+1];
        sum = new int[N+1];
        int testCase = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            data[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + data[i];
        }
        for(int i = 0 ; i < testCase; i++){
            st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int n = sum[k] - sum[j-1];
            bw.append(n+"\n");
        }
        bw.flush();

    }
}
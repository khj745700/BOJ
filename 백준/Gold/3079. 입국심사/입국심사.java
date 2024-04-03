import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        arr = new long[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        long answer = Long.MAX_VALUE;
        long l = min;
        long r = max * M;
        while(l <= r) {
            long mid = (l + r)/ 2;

            long cnt = 0;
            for(int i = 0 ; i < N; i++) {
                cnt += mid / arr[i];
                if(cnt >= M) {
                    break;
                }
            }
            if(cnt < M) {
                l = mid + 1;
            }else {
                r = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        System.out.println(answer);
    }
}

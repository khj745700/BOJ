import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }

        for(int i = max * min ; i < Integer.MAX_VALUE; i++) {
            boolean flag = true;
            for(int j = 0; j < N; j++){
                if(i % arr[j] != 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                System.out.println(i);
                return;
            }
        }
    }
}

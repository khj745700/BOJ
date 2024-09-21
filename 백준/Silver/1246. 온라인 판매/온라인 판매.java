import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        int val = 0;
        for(int i = 0; i < M; i++){
            int sum = 0;
            for(int j = i; j < M && j - i < N; j++){
                sum += arr[i];
            }
            if(sum > max){
                max = sum;
                val = arr[i];
            }
        }
        System.out.print(val + " " + max);
    }
}
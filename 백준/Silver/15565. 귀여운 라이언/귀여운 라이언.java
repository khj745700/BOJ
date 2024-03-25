import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] b = new int[2];
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;

        while(l != N) {
            while(b[0] != K && r < N) {
                if(arr[r] == 1) {
                    b[0]++;
                }
                if(arr[r] == 2) {
                    b[1]++;
                }
                r++;

            }
            if(b[0] == K) {
                MIN = Math.min(MIN, b[0]+b[1]);
            }

            boolean flag = false;
            while(l < N) {
                if(arr[l] == 1 && flag) {
                    break;
                }
                if(arr[l] == 1 && !flag) {
                    b[0]--;
                    flag = true;
                }
                if(arr[l] == 2) {
                    b[1]--;
                }
                l++;
            }
        }
        if(MIN == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(MIN);
        }
    }


}


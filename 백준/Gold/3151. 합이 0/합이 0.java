import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long ans = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i = 0 ; i < N; i++) {
            if(arr[i] > 0) break;
            int l = i + 1;
            int r = N - 1;

            while(l < r) {
                int s = 1;
                int e = 1;
                int mid = arr[i] + arr[l] + arr[r];
                if(mid == 0) {
                    if(arr[l] == arr[r]) {
                        ans += comb(r - l + 1);
                        break;
                    }

                    while(l + 1 < r && arr[l] == arr[l + 1]) {
                        s++;
                        l++;
                    }
                    while(l < r - 1 && arr[r] == arr[r-1]) {
                        e++;
                        r--;
                    }

                    ans += (long) s * e;
                }

                if(mid > 0) {
                    r--;
                }else l++;
            }
        }
        System.out.println(ans);
    }

    static int comb(int n) {
        return n * (n - 1) / 2;
    }
}
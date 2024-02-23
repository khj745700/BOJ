import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = seq[0];
        int leng = 1;

        for(int i = 1; i < N ; i++) {
            int key = seq[i];

            if(LIS[leng-1] < key) {
                leng++;
                LIS[leng - 1] = key;
            }
            else {
                int l = 0;
                int hi = leng;
                while (l < hi) {
                    int mid = (l + hi) >>> 1;

                    if(LIS[mid] < key) {
                        l = mid + 1;
                    }
                    else {
                        hi = mid;
                    }
                }

                LIS[l] = key;
            }
        }
        System.out.println(leng);
    }
}
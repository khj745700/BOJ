import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        min = new long[101];


        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < i; j++) {
                min[i] += j;
            }
        }

        for( ; L < 101; L++) {
            if((N - min[L]) % L == 0 && N >= min[L]) {
                break;
            }
        }

        if(L == 101) {
            System.out.println(-1);
        }else {
            long a1 = (N - min[L])/L;
            for(int i = 0 ; i < L; i++) {
                System.out.print(a1 + i + " ");
            }
        }

    }
}

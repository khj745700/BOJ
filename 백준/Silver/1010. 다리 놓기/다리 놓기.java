import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());



        StringTokenizer st;
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            System.out.println(combination(right,left));
        }
    }

    static long combination(int n, int r) {
        long answer = 1;
        r = Math.min(r, n-r);

        for(int i = 0; i < r; i++ ) {
            answer *= (n - i);
        }

        for(int i = r; i >= 1; i--) {
            answer /= i;
        }

        return answer;
    }
}

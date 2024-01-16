import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(combination(N,M));
    }


    static BigDecimal combination(int n, int r) {
        r = Math.min(r, n-r);
        BigDecimal answer = BigDecimal.valueOf(1);
        for(int i = 0; i < r; i++) {
            answer = answer.multiply(BigDecimal.valueOf(n - i));
        }

        for(int i = 1; i <= r; i++) {
            answer = answer.divide(BigDecimal.valueOf(i));
        }

        return answer;
    }
}

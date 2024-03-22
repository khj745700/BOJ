import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int henry(int a, int b) {
        int n = b / a;
        if( n * a >= b) {
            return n;
        }
        return n + 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while(true) {
                int x = henry(a, b);
                if(a * x == b) {
                    sb.append(x);
                    sb.append('\n');
                    break;
                }
                a = a * x - b;
                b = b * x;
            }
        }
        System.out.println(sb);
    }
}


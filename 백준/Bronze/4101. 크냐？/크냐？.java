import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(N != 0 || M != 0) {
            if( N > M) {
                sb.append('Y');
                sb.append('e');
                sb.append('s');

            }else {
                sb.append('N');
                sb.append('o');
            }
            sb.append('\n');
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }
        System.out.println(sb);
    }

}


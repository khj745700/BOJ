import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    static int E, S, M;
    private final static int MAX_E = 16;
    private final static int MAX_S = 29;
    private final static int MAX_M = 20;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = stoi(st.nextToken());
        S = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;
        int count = 1;
        while (e != E || s != S || m != M) {
            s = (s + 1) % MAX_S;
            if( s == 0 ) {
                ++s;
            }
            e = (e + 1) % MAX_E;
            if(e == 0) {
                ++e;
            }
            m = (m + 1) % MAX_M;
            if(m == 0) {
                ++m;
            }
            ++count;
        }

        System.out.println(count);
    }

}

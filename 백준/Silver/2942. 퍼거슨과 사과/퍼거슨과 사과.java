import java.io.*;
import java.util.*;

public class Main {
    static int R, G;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        R = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        int gcb = gcb(R,G);

        for(int i = 1 ; i <= gcb; i++) {
            if(gcb % i == 0) {
                sb.append(i).append(' ').append(R / i).append(' ').append(G / i).append('\n');
            }
        }
        System.out.print(sb);
    }

    static int gcb(int a, int b) {
        if(a == 0 || b == 0 ){
            return a + b;
        }
        if(a> b) {
            return gcb(a%b, b);
        }else {
            return gcb(a, b%a);
        }
    }
}
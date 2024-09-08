import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W, X, Y;
    static int[][] B;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        B = new int[H+X][W+Y];
        A = new int[H][W];
        for(int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W + Y; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < H; i++) {
            for(int j = 0 ; j < W; j++) {
                A[i][j] = B[i][j];
            }
        }

        for(int i = X; i < H; i++ ) {
            for(int j = Y; j < W; j++) {
                A[i][j] -= A[i-X][j-Y];
            }
        }

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
               sb.append(A[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
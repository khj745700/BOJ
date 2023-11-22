import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = y; i < y+10; i++) {
                for(int j = x; j < x+10; j++) {
                    arr[i][j]++;
                }
            }
        }
        int integral = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(arr[i][j] >= 1) {
                    integral++;
                }
            }
        }
        System.out.println(integral);
    }
}

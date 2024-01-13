import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int x1,y1,r1,x2,y2,r2;
        StringTokenizer st;
        while(T --> 0) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            int distance_pow = (int)distance(x1,y1,x2,y2);

            if(x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
            }else if(distance_pow > Math.pow(r1+r2, 2)) {
                System.out.println(0);
            }else if(distance_pow < Math.pow(r2 - r1, 2)){
                System.out.println(0);
            } else if(distance_pow == Math.pow(r2 - r1, 2)) {
                System.out.println(1);
            }else if(distance_pow == Math.pow(r1 + r2, 2)) {
                System.out.println(1);
            }else {
                System.out.println(2);
            }
        }
    }

    static double distance(int x1, int y1, int x2, int y2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);
    }

}

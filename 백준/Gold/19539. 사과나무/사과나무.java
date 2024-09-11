import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int one = 0;
        int two = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ;i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            sum += target;
            two += target / 2;
            one += target % 2;
        }
        if(sum % 3 > 0 || one > two) {
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }

}
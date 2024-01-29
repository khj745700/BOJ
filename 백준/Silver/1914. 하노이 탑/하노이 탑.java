import java.io.*;
import java.math.BigDecimal;
import java.util.*;
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static boolean canSb;
    public static int hanoi(int target, int from, int to) throws IOException {
        if(target == 1) {
            sb.append(from).append(" ").append(to);
            sb.append("\n");
            return 1;
        }
        int sum = 0;
        int remain = 6 - (from + to);
        sum += hanoi(target - 1, from, remain);
        sb.append(from).append(" ").append(to);
        sb.append("\n");
        sum += 1;
        sum += hanoi(target - 1, remain, to);
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        canSb = n <= 20;
        if(canSb)
            hanoi(n, 1, 3);
        BigDecimal  bigDecimal = new BigDecimal(2);
        bigDecimal = bigDecimal.pow(n).add(new BigDecimal(-1));
        bw.append(bigDecimal.toString());
        if(canSb) {
            bw.newLine();
            bw.append(sb.toString());
        }
        bw.flush();
    }
}

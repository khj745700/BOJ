import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String toBinary = Integer.toBinaryString(N);


        char cur = 0;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while(!isK(toBinary)) {
            for(int j = toBinary.length() - 1; j >= 0; j-- ) {
                cur = toBinary.charAt(j);
                if(cur == '1') {
                    sb.insert(0, '1');
                    break;
                }
                sb.append(cur);
            }
            int target1 = Integer.parseInt(sb.toString(), 2);
            int target2 = Integer.parseInt(toBinary, 2);
            int next = target2 + target1;
            toBinary = Integer.toBinaryString(next);
            sb.setLength(0);
            sum += target1;
        }

        System.out.println(sum);
    }


    static boolean isK(String str) {
        int count = 0 ;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                count++;
            }
        }
        return count <= K;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        int test_case = 1;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            List<String> list = new LinkedList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }

            int q = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < q; i++) {
                char c = st.nextToken().charAt(0);
                int x = 0;
                int y = 0;

                if (c == 'I') {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        list.add(x + j, st.nextToken());
                    }
                }
                if (c == 'D') {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        list.remove(x + j);
                    }
                }
                if (c == 'A') {
                    y = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < y; j++) {
                        list.add(st.nextToken());
                    }
                }
            }


            sb.append('#')
                    .append(test_case++)
                    .append(' ');
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i));
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
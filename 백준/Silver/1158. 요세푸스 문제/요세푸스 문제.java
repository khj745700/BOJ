import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>(n);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            queue.add(i + 1);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0 ; j < k - 1; j++) {
                int val = queue.poll();
                queue.add(val);
            }
            answer.add(queue.poll());
        }

        bw.append("<");
        for (int i = 0 ; i < n; i++) {
            bw.append(Integer.toString(answer.get(i)));
            if(i != n - 1) {
                bw.append(", ");
            }
        }
        bw.append(">");
        bw.flush();
    }
}

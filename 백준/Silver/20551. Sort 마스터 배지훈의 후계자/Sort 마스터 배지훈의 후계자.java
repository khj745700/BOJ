import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static TreeMap<Integer, Integer> bucket;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bucket = new TreeMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            list.add(target);
        }

        list.sort(null);
        for(int i = 0 ; i < N ; i++) {
            int target = list.get(i);
            if(!bucket.containsKey(target)) {
                bucket.put(target, i);
            }
        }
        for(int i = 0 ; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            if(bucket.containsKey(target)) {
                sb.append(bucket.get(target));
                sb.append('\n');
            }else {
                sb.append(-1);
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
}
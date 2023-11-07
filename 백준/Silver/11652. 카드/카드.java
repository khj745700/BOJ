import java.util.*;
import java.io.*;


public class Main{
    static int N;
    static Map<Long, Long> bucket = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++) {
            long n = Long.parseLong(br.readLine());
            bucket.putIfAbsent(n, 0L);
            bucket.put(n, bucket.get(n) + 1);
        }

        long max = Long.MIN_VALUE, n = Long.MAX_VALUE;
        for(Map.Entry<Long, Long> entry : bucket.entrySet()) {
            if(entry.getValue() > max) {
                n = entry.getKey();
                max = entry.getValue();
            }
            
            if(entry.getValue() == max && entry.getKey() < n){
                n = entry.getKey();
            }
        }

        System.out.println(n);
    }
}

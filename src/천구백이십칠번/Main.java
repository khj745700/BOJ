package 천구백이십칠번;
import java.util.*;
import java.io.*;


public class Main{
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            switch (x) {
                case 0 :
                    if(pq.isEmpty()){
                        bw.append('0');
                    }else {
                        bw.append(String.valueOf(pq.poll()));
                    }
                    bw.newLine();
                    break;
                default :
                    pq.add(x);
            }
        }
        bw.flush();
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static int G, P;
    static boolean[] gate;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        gate = new boolean[G+1];
        dist = new int[G+1];
        for(int i = 1; i <= G; i++) {
            dist[i] = i;
        }

        int count = 0;
        for(int i = 0; i < P; i++) {
            int val = Integer.parseInt(br.readLine());
            if((val = find(val)) == 0) {
                break;
            }
            union(val, val-1);
            count++;
        }
        System.out.println(count);
    }
    static int find(int v){
        if(v == dist[v]){
            return v;
        }

        return dist[v] = find(dist[v]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) {
            return false;
        }

        dist[a] = b;
        return true;
    }

}

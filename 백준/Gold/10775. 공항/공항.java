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
            if(setGate(val)){
                count++;
            }else {
                break;
            }
        }
        System.out.println(count);
    }


    static boolean setGate(int idx) {

        for(int i = dist[idx]; i >= 1; i--){
            if(!gate[i]){
                for(int j = idx; j>= i; j--){
                    dist[j] = i;
                }
                return gate[i] = true;
            }
        }

        return false;
    }

}


import java.io.*;
import java.util.*;


public class Main {
    static int[] data = new int[1000001];
    static int findSet(int p){
        if(p == data[p]){
            return p;
        }
        data[p] = findSet(data[p]);
        return data[p];
    }

    static void unionSet(int a, int b){
        int ap = findSet(a);
        int bp = findSet(b);
        data[ap] = bp;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i <= n ; i++){
            data[i] = i;
        }
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());
            if(first == 0){
                unionSet(second,third);
            }else{
                if(findSet(second) == findSet(third)){
                    bw.append("yes").append("\n");
                }else{
                    bw.append("no").append("\n");
                }
            }
        }
        bw.flush();
    }
}

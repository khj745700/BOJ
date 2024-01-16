
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[] data;
    static int[] ans;
    static int[] visit;

    static void pers(int depth, int N, int R){
        if (depth == R){
            //완성,, 출력하기
            for(int i = 0 ; i < R ; i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 0 ; i < N; i++){
            if(visit[i] == 0){
                ans[depth] = data[i];
                visit[i] = 1;
                pers(depth+1, N, R);
                visit[i] = 0;
            }
        }

    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        data = new int[n];
        ans = new int[n];
        visit = new int[n];
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        pers(0,n,m);
    }
}
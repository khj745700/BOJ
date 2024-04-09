import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] naegudo;
    static int[] weight;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        naegudo = new int[N];
        weight = new int[N];

        for(int i  = 0 ; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nae = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            naegudo[i] = nae;
            weight[i] = w;
        }

        backtracking(0, 0 );
        System.out.println(max);
    }



    static void backtracking(int broken, int now) {
        if(now == N) {
            max = Math.max(broken, max);
            return;
        }

        if(naegudo[now] <= 0) {
            backtracking(broken, now + 1);
            return;
        }

        boolean flag = false;
        for(int i = 0; i < N; i++) {

            if(naegudo[i] <= 0)  {
                continue;
            }
            if(now == i) {
                continue;
            }
            flag = true;
            //깨지지 않을 조건
            if(naegudo[now] > weight[i]) {
                //상대 계란이 깨질 조건
                if(naegudo[i] <= weight[now]){
                    naegudo[i] -= weight[now];
                    naegudo[now] -= weight[i];
                    backtracking(broken+1, now  + 1);
                    naegudo[i] += weight[now];
                    naegudo[now] += weight[i];
                }
                //상대 계란이 깨지지 않을 조건
                else if(naegudo[i] > weight[now]){
                    naegudo[i] -= weight[now];
                    naegudo[now] -= weight[i];
                    backtracking(broken, now + 1);
                    naegudo[i] += weight[now];
                    naegudo[now] += weight[i];
                }
            }
            //깨질 조건
            else if(naegudo[now] <= weight[i]) {
                //상대 계란이 깨질 조건
                if(naegudo[i] <= weight[now]){
                    naegudo[now] -= weight[i];
                    naegudo[i] -= weight[now];
                    backtracking(broken+2, now + 1);
                    naegudo[i] += weight[now];
                    naegudo[now] += weight[i];
                }
                //상대 계란이 깨지지 않을 조건
                else if(naegudo[i] > weight[now]){
                    naegudo[now] -= weight[i];
                    naegudo[i] -= weight[now];
                    backtracking(broken+1, now + 1);
                    naegudo[i] += weight[now];
                    naegudo[now] += weight[i];
                }
            }
        }
        if(!flag)
            backtracking(broken, now + 1);
    }
}

package 천이백육십번;
import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;
    static int V;
    static int[][] arr;

    static void BFS(int initNode, BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(initNode);
        while(!queue.isEmpty()){
            int target = queue.poll();
            for(int i = 1; i <= N; i++){
                if(arr[target][i] == 1){
                    queue.add(i);
                }
            }
            bw.append(String.valueOf(target));
        }

    }

    static void DFS(int initNode, BufferedWriter bw) throws IOException{
        Stack<Integer> stack = new Stack<>();
        stack.push(initNode);
        while(!stack.isEmpty()){
            int target = stack.pop();
            for(int i = 1; i <= N; i++){
                if(arr[target][i] == 1){
                    stack.push(i);
                }
            }
            bw.append(String.valueOf(target));
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data = br.readLine().split(" ");
        N = Integer.parseInt(data[0]);
        M = Integer.parseInt(data[1]);
        V = Integer.parseInt(data[2]);

        arr = new int[N+1][N+1];


        for(int i = 0 ; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        BFS(V, bw);
        bw.flush();
        DFS(V, bw);
        bw.flush();
    }
}

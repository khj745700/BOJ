import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int depth;

    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        depth = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTracking(0, new ArrayList<>());
        bw.flush();
    }


    static void backTracking(int depth, List<Integer> list) throws IOException {
        if(depth == Main.depth) {
            for(int i = 0; i < list.size(); i++) {
                bw.append(list.get(i).toString()).append(" ");
            }
            bw.newLine();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                backTracking(depth + 1, list);
                list.remove((Integer) arr[i]);
                visited[i] = false;
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int test_case = 1;
        while(T --> 0) {
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            bw.append("#" + test_case++ + " ");
            arr = new int[N * 2];
            visited = new boolean[N * 2];
            for(int i = 0 ; i < N * 2; i++) {
                arr[i] =Integer.parseInt(st.nextToken());
            }

            for(int i = N * 2 - 1; i >= 0; i--) {
                if(visited[i]) continue;
                int cur = arr[i] / 4 * 3;
                for(int j = 0 ; j < i ; j++) {
                    if(arr[j] == cur && !visited[j]) {
                        visited[j] = true;
                        list.add(arr[j]);
                        break;
                    }
                }
            }
            Collections.reverse(list);
            list.forEach(integer -> {
                try {
                    bw.append(integer + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bw.newLine();
        }
        bw.flush();
    }
}

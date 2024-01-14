import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> list;
    static int N;
    static int M;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        List<Integer> answerList = new ArrayList<>();

        dfs(0, 0, answerList);
        bw.flush();
    }


    static void dfs(int idx, int depth, List<Integer> answerList) throws IOException {
        if(depth == M) {
            for(int i = 0; i < answerList.size(); i++) {
                bw.append(answerList.get(i) + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = idx; i < N; i++) {
            answerList.add(list.get(i));
            dfs(i, depth + 1, answerList);
            answerList.remove(list.get(i));
        }

    }
}

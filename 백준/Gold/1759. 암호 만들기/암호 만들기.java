import java.io.*;
import java.util.*;


public class Main {
    static int L;
    static int C;
    static char[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        backtracking(0, 0, new ArrayList<>());
    }


    static void backtracking(int depth, int start, List<Character> list) throws IOException {
        if(depth == L) {
            int vowels = countVowels(list);
            if(vowels >= 1 && depth - vowels >= 2){
                for(char c : list) {
                    bw.append(c);
                }
                bw.newLine();
                bw.flush();
            }
            return;
        }

        for(int i = start; i < C; i++) {
            list.add(arr[i]);
            backtracking(depth+1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


    static int countVowels(List<Character> list) {
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            switch(list.get(i)) {
                case 'a', 'e', 'i', 'o', 'u' :
                    count++;
            }
        }
        return count;
    }
}

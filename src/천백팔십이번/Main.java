package 천백팔십이번;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int target;
    static void subSum(int index, int sum, List<Integer> all) {
        for(int i = index ; i < arr.length; i++) {
            sum += arr[i];
            if(sum == target){
                all.add(sum);
            }
            subSum(i + 1, sum, all);
            sum -= arr[i];
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        arr = new int[count];
        target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> all = new ArrayList<>();
        subSum(0, 0, all);

        bw.append(Integer.toString(all.size()));
        bw.flush();
    }
}

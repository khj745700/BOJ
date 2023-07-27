package 사천구백사십팔번;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static boolean[] arr = new boolean[300001];

    public static void init() {
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;
        for(int i = 2; i < arr.length; i++){
            if(arr[i]) {
                int num = i + i;
                while(num < arr.length) {
                    arr[num] = false;
                    num += i;
                }
            }
        }
    }

    public static int count(int start, int end) {
        return (int)IntStream.rangeClosed(start + 1, end).filter(num -> arr[num]).count();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        init();
        String str = br.readLine();
        while(!str.equals("0")){
            int num = Integer.parseInt(str);
            bw.append(Integer.toString(count(num, num*2)));
            bw.newLine();
            str = br.readLine();
        }
        bw.flush();
    }
}

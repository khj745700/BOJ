package 구천이십번;

import java.io.*;
import java.util.Arrays;

public class Main {
    static boolean[] eratosthenes = new boolean[10001];

    static void init() {
        Arrays.fill(eratosthenes, true);
        eratosthenes[0] = false;
        eratosthenes[1] = false;

        for(int i = 2; i < eratosthenes.length; i++){
            if(eratosthenes[i]){
                int num = i + i;
                while(num < eratosthenes.length) {
                    eratosthenes[num] = false;
                    num += i;
                }
            }
        }
    }

    static int[] determine(int target) {
        for(int i = target/2; i < target; i++) {
            if(eratosthenes[i] && eratosthenes[target - i]){
                return new int[] {target - i, i};
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < caseNum; i++){
            int[] data = determine(Integer.parseInt(br.readLine()));
            bw.append(Integer.toString(data[0])).append(' ').append(Integer.toString(data[1]));
            bw.newLine();
        }
        bw.flush();
    }
}

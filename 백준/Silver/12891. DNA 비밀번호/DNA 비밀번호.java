import java.util.*;
import java.io.*;

public class Main {
    static int P, S;
    static char[] seq;
    static int[] bucket;
    static int[] minimum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        bucket = new int[4];
        minimum = new int[4];
        seq = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());


        int count = 0;

        for(int i = 0; i < 4; i++) {
            minimum[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < P; i++) {
            bucket[switchVal(seq[i])]++;

        }

        if(isCount()) {
            count++;
        }

        for(int i = P; i < S; i++) {
            bucket[switchVal(seq[i])] ++;
            bucket[switchVal(seq[i-P])]--;
            if(isCount()){
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean isCount() {
        boolean flag = true;
        for(int i = 0 ; i < 4; i++) {
            if(minimum[i] > bucket[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    static int switchVal(char c) {
        switch (c) {
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            default : return 3;
        }
    }

}

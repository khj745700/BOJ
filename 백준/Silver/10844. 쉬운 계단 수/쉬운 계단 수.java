import java.io.*;
import java.util.*;


public class Main {
    static Long[][] data;
    static int MOD;
    public static long recur(int digit, int num){
        if(digit == 1){
            return data[digit][num];
        }
        if(data[digit][num] == null){
            if(num == 9){
                data[digit][num] = recur(digit -1, 8);
            }
            else if(num == 0){
                data[digit][num] = recur(digit-1, 1);
            }
            else{
                data[digit][num] = recur(digit-1, num-1) + recur(digit-1, num+1);
            }
        }
        return data[digit][num] % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        data = new Long[num+1][10];
        Arrays.fill(data[1],1L);
        MOD = 1000000000;
        long result = 0;
        for(int i = 1; i <= 9; i++){
            result += recur(num,i);
        }
        bw.append(Long.toString(result%MOD));
        bw.flush();
    }
}

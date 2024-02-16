import java.util.*;
import java.io.*;


public class Main{ 
    static int[] upDp;
    static int[] downDp;
    static int[] value;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int length = Integer.parseInt(br.readLine());
        upDp = new int[length];
        downDp = new int[length];
        value = new int[length];
        
        String[] values = br.readLine().split(" ");
        for(int i = 0 ; i < length; i++) {
            value[i] = Integer.parseInt(values[i]);            
        }

        for(int i = 0 ; i < length; i++) {
            // i가 타겟
            upDp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(value[i] > value[j] && upDp[i] < upDp[j] + 1) {
                    upDp[i] = upDp[j] + 1;
                }
            }
        }
        
        for(int i = length - 1; i >= 0 ; i--) {
            downDp[i] = 1;
            
            for(int j = length - 1; j > i ; j--) {
                if(value[i] > value[j] && downDp[i] < downDp[j] + 1) {
                    downDp[i] = downDp[j] + 1;
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < length; i++) {
            max = Math.max(max, upDp[i] + downDp[i] - 1);
        }
        bw.append(String.valueOf(max));
        bw.flush();
            
    }
}
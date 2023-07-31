package 사천삼백칠십오번;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        List<String> inputs = new ArrayList<>();
        while(str != null) {
            inputs.add(str);
            str = br.readLine();
        }

        for(String num : inputs) {
            int n = Integer.parseInt(num);

            int oneRepeat = 0;
            for(int i = 1; true; i++) {
                oneRepeat = oneRepeat * 10 + 1;
                oneRepeat = oneRepeat % n;
                if (oneRepeat == 0) {
                    bw.append(Integer.toString(i));
                    bw.newLine();
                    break;
                }
            }
        }
        bw.flush();
    }
}

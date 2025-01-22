import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] ips = new int[n];
        for(int i = 0; i < n; i++) {
            String ip = br.readLine();
            int val = ipToByte(ip);
            ips[i] = val;
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        int dif = max ^ min;

        int m = Integer.numberOfLeadingZeros(dif);

        int networkMasking = 0xffffffff << (32-m);
        if(m == 0 && min != max) {
            networkMasking = 0;
        }
        int networkPrefix = min & networkMasking;

        System.out.println(byteToIp(networkPrefix));
        System.out.println(byteToIp(networkMasking));
    }


    static Integer ipToByte(String ip) {
        String[] ipNum = ip.split("\\.");
        int num = 0;
        for(int i = ipNum.length - 1; i >= 0; i--) {
            int val = Integer.parseInt(ipNum[ipNum.length - 1 - i]);
            val = val << (8 * i);
            num |= val;
        }
        return num;
    }

    static String byteToIp(int num) {
        StringBuilder sb = new StringBuilder();
        int count = 7;
        int sum = 0;
        for(int i = 31 ; i >= 0; i--) {
            if((num & (1 << i)) != 0) {
                sum += Math.pow(2, count);
            }
            count --;

            if(count == -1) {
                sb.append(sum);
                if(i != 0) {
                    sb.append(".");
                }
                sum = 0;
                count = 7;
            }
        }
        return sb.toString();
    }
}
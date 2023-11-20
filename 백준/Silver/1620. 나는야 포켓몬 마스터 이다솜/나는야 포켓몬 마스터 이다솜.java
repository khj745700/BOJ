import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();
    static String[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int count = 1;
        list = new String[size + 1];
        while(size --> 0) {
            String input = br.readLine();
            list[count] = input;
            map.put(input, count++);
        }

        while(T --> 0) {
            String input = br.readLine();
            if(Character.isDigit(input.charAt(0))) {
                bw.append(list[Integer.parseInt(input)]);
            }else {
                bw.append(String.valueOf(map.get(input)));
            }
            bw.newLine();
        }
        bw.flush();
    }
}

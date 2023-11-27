import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] count = new int[10];
        int[] num = new int[3];

        for(int i = 0 ; i < 3; i++){
            num[i] = Integer.parseInt(br.readLine());
        }
        int value = num[0] * num[1] * num[2];
        char[] str = Integer.toString(value).toCharArray();
        for(int i = 0 ; i < str.length; i++){
            count[str[i]-'0']++;
        }
        for(int i = 0 ; i < 10; i++){
            bw.append(Integer.toString(count[i])+'\n');
        }
        bw.flush();
    }
}
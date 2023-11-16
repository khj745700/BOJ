import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        if(!str.contains("0")){
            System.out.println(-1);
            return;
        }
        char[] strToChar = str.toCharArray();
        long a = 0;
        
        for(int i = 0; i < strToChar.length; i++) {
            a += (long)strToChar[i] - '0';
        }
        
        if (a % 3 != 0){
            System.out.println(-1);
            return;
        }
        
        Arrays.sort(strToChar);

        for (int i = strToChar.length - 1; i >= 0 ; i--) {
            System.out.print(strToChar[i]);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        for(int i = 0; i < input.length; i++) {
            if(Character.isUpperCase(input[i])) {
                input[i] = Character.toLowerCase(input[i]);
            }else {
                input[i] = Character.toUpperCase(input[i]);
            }
        }

        System.out.println(input);
    }
}
